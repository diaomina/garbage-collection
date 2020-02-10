package com.soft.model;

public class GarbageType {
    private Integer id;

    private String garbagetypename;

    private String garbagetip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGarbagetypename() {
        return garbagetypename;
    }

    public void setGarbagetypename(String garbagetypename) {
        this.garbagetypename = garbagetypename == null ? null : garbagetypename.trim();
    }

    public String getGarbagetip() {
        return garbagetip;
    }

    public void setGarbagetip(String garbagetip) {
        this.garbagetip = garbagetip == null ? null : garbagetip.trim();
    }
}