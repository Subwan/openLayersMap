package com.openLayersMap.www.Model;


public class Line {
    private long id;
    private String type;
    private java.util.List<double[]> coordinates;

    public Line(long id, String type, java.util.List<double[]> coordinates) {
        setId(id);
        setType(type);
        setCoordinates(coordinates);
    }

    public Line(String type, java.util.List<double[]> coordinates) {
        setType(type);
        setCoordinates(coordinates);
    }



    public Line(Long id, String type, java.util.List<double[]> coordinates) {
        setId(id);
        setType(type);
        setCoordinates(coordinates);
    }

    public void setId(long id) { this.id = id; };

    public long getId() {return  id; };

    public void setType(String type) { this.type = type; };

    public String getType() { return type; };

    public void setCoordinates(java.util.List<double[]> coordinates) { this.coordinates = coordinates; };

    public java.util.List<double[]> getCoordinates() { return coordinates; };
}
