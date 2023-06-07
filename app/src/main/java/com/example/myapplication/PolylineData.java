package com.example.myapplication;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

public class PolylineData {
    Polyline polyline;
    LatLng latLng;
    Double dureation;

    public PolylineData(Polyline polyline, LatLng latLng, Double dureation) {
        this.polyline = polyline;
        this.latLng = latLng;
        this.dureation = dureation;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public Double getDureation() {
        return dureation;
    }

    public void setDureation(Double dureation) {
        this.dureation = dureation;
    }
}
