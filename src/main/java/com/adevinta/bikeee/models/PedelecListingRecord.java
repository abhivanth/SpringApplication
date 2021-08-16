package com.adevinta.bikeee.models;

import java.util.Date;

public class PedelecListingRecord {

    private Long id;

    private String make;

    private String model;

    private Integer price;

    private Long userId;

    private Date date;

    public PedelecListingRecord(Long id, String make, String model, Integer price, Long userId, Date date) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.price = price;
        this.userId = userId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getPrice() {
        return price;
    }

    public Long getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }
}
