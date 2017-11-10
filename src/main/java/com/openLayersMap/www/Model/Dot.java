package com.openLayersMap.www.Model;


public class Dot {
    private long id;
    private double lat;
    private double lon;

    public Dot(long id, double lat, double lon) {
        setId(id);
        setLat(lat);
        setLon(lon);
    }

    public Dot(double lat, double lon) {
        setLat(lat);
        setLon(lon);
    }

    public Dot(Long id, Double lat, Double lon) {
        setId(id);
        setLat(lat);
        setLon(lon);
    }

    public void setId(long id) { this.id = id; };

    public long getId() {return  id; };

    public void setLat(double lat) { this.lat = lat; };

    public double getLat() { return lat; };

    public void setLon(double lon) { this.lon = lon; };

    public double getLon() { return lon; };
}
