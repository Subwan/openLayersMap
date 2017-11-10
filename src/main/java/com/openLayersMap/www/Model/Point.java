package com.openLayersMap.www.Model;


public class Point {
    private long id;
    private String type;
    private double[] coordinates;


    public Point(String type, double[] coordinates) {
        setType(type);
        setCoordinates(coordinates);
    }

    public Point(Long id, String type, double[] coordinates) {
        setId(id);
        setType(type);
        setCoordinates(coordinates);
    }

    public void setId(long id) { this.id = id; };

    public long getId() {return  id; };

    public void setType(String type) { this.type = type; };

    public String getType() { return type; };

    public void setCoordinates(double[] coordinates) { this.coordinates = coordinates; };

    public double[] getCoordinates() {return coordinates; };
}
