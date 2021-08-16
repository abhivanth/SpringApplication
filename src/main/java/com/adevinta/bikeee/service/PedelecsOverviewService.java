package com.adevinta.bikeee.service;

import com.adevinta.bikeee.models.PedelecListingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PedelecsOverviewService {

    private final IPedelecsDataProvider pedelecsDataProvider;

    @Autowired
    public PedelecsOverviewService(IPedelecsDataProvider pedelecsDataProvider) {
        this.pedelecsDataProvider = pedelecsDataProvider;
    }

    public List<PedelecOverviewRecord> getTopThree() {
        List<PedelecListingRecord> pedelecListingRecords = pedelecsDataProvider.getAllRecords();
        Map<String, PedelecOverviewRecord> pedelecOverviewRecordMap = new HashMap<>();
        for (PedelecListingRecord record : pedelecListingRecords) {
            String key = computeKey(record.getMake(), record.getModel());
            pedelecOverviewRecordMap
                    .computeIfAbsent(key, s -> new PedelecOverviewRecord(record.getModel(), record.getMake()))
                    .increment();
        }
        List<PedelecOverviewRecord> pedelecTopRecords =
                pedelecOverviewRecordMap.values().stream()
                        .sorted((r1, r2) -> Long.compare(r2.getCount(), r1.getCount()))
                        .collect(Collectors
                                .toList());
        if (pedelecTopRecords.size() > 3) {
            return pedelecTopRecords.subList(0, 3);
        } else {
            return pedelecTopRecords;
        }
    }

    private String computeKey(String make, String model) {
        return make.toUpperCase() + model.replace("-", " ").toUpperCase();
    }

}
