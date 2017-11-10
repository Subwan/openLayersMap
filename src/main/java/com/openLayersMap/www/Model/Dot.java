package com.openLayersMap.www.Model;


public class Dot {
    double lat;
    double lon;

    public Dot (double lat, double lon) {
        setLat(lat);
        setLon(lon);
    }


    public void setLat(double lat) { this.lat = lat; };

    public double getLat() {return lat; };

    public void setLon(double lon) { this.lon = lon; };

    public double getLon() {return lon; };
}
