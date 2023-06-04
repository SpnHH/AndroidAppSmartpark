package com.example.myapplication.DBUtils;

public class ParkingSpot {
    private String id;
    private double latitude;
    private double longitude;
    private boolean status;

    public ParkingSpot() {
    }

    public ParkingSpot(String id, double latitude, double longitude, boolean status) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
