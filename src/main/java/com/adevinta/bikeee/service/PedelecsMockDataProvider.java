package com.adevinta.bikeee.service;

import com.adevinta.bikeee.models.PedelecListingRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// This is used to mimic the database
@Service
public class PedelecsMockDataProvider implements IPedelecsDataProvider {

    public static String PEDELECS_DB_FILE_NAME = "pedelecs_db.csv";
    private static final Logger log = LoggerFactory.getLogger(PedelecsMockDataProvider.class);
    private final List<PedelecListingRecord> pedelecListingRecords = new ArrayList<>();

    @PostConstruct
    public void loadData() throws IOException {

        Resource resource = new ClassPathResource(PEDELECS_DB_FILE_NAME);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        List<String> csvRecords = reader.lines().collect(Collectors.toList());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        //remove header
        csvRecords.remove(0);
        for (String csvRecord : csvRecords) {
            List<String> colValues = Arrays.stream(csvRecord.split(",")).map(String::trim)
                    .collect(Collectors.toList());
            Long id = Long.valueOf(colValues.get(0));
            String make = colValues.get(1);
            String model = colValues.get(2);
            Integer price = Integer.valueOf(colValues.get(3));
            Long userId = Long.valueOf(colValues.get(4));
            Date date = null;
            try {
                date=  dateFormatter.parse(colValues.get(5));
            } catch (ParseException e) {
                log.error("Error while parsing Date String to date for record {}", csvRecord);
            }
            pedelecListingRecords.add(new PedelecListingRecord(id, make, model, price, userId, date));
        }
    }


    @Override
    public List<PedelecListingRecord> getAllRecords() {
        return new ArrayList<>(pedelecListingRecords);
    }
}
