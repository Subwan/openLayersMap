package com.openLayersMap.www.Model;


import java.util.List;

public class Line {
    private long id;
    private String type;
    private List<double[]> coordinates;

    public Line(long id, String type, List<double[]> coordinates) {
        setId(id);
        setType(type);
        setCoordinates(coordinates);
    }

    public Line(String type, List<double[]> coordinates) {
        setType(type);
        setCoordinates(coordinates);
    }


    public Line(Long id, String type, List<double[]> coordinates) {
        setId(id);
        setType(type);
        setCoordinates(coordinates);
    }

    public void setId(long id) { this.id = id; };

    public long getId() {return  id; };

    public void setType(String type) { this.type = type; };

    public String getType() { return type; };

    public void setCoordinates(List<double[]> coordinates) { this.coordinates = coordinates; };

    public List<double[]> getCoordinates() { return coordinates; };
}
