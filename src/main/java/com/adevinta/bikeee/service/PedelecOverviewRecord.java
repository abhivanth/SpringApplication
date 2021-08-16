package com.adevinta.bikeee.service;

public class PedelecOverviewRecord {

    private final String model;
    private final String make;
    private long count =0L;

    public PedelecOverviewRecord(String model, String make) {
        this.model = model;
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public long getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

}
