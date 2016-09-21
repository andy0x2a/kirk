package com.newmansoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MapPoint {

    private double lat;

    private double lng;

    @JsonIgnore
    private long timestamp;
    public MapPoint() {
    }

    public MapPoint(double lat, double lng, long timestamp) {
        this.lat = lat;
        this.lng = lng;
        this.timestamp = timestamp;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
}
