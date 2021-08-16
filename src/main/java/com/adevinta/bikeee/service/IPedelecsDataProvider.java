package com.adevinta.bikeee.service;

import com.adevinta.bikeee.models.PedelecListingRecord;

import java.util.List;

public interface IPedelecsDataProvider {

    public List<PedelecListingRecord> getAllRecords();
}
