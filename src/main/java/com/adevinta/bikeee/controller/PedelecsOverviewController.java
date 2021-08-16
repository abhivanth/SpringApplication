package com.adevinta.bikeee.controller;

import com.adevinta.bikeee.service.PedelecOverviewRecord;
import com.adevinta.bikeee.service.PedelecsMockDataProvider;
import com.adevinta.bikeee.service.PedelecsOverviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class PedelecsOverviewController {


    private static final Logger log = LoggerFactory.getLogger(PedelecsMockDataProvider.class);
    private final PedelecsOverviewService pedelecsOverviewService;

    @Autowired
    public PedelecsOverviewController(PedelecsOverviewService pedelecsOverviewService) {
        this.pedelecsOverviewService = pedelecsOverviewService;
    }



    @GetMapping("topthree")
    public List<PedelecOverviewRecord> getTopThree() {
        return pedelecsOverviewService.getTopThree();
    }

}
