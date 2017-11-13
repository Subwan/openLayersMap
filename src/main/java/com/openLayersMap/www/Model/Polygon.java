package com.openLayersMap.www.Model;


import java.util.List;

public class Polygon {
    private long id;
    private String type;
    private List<List<double[]>> coordinates;

    public Polygon(long id, String type, List<List<double[]>> coordinates) {
        setId(id);
        setType(type);
        setCoordinates(coordinates);
    }

    public Polygon(String type, List<List<double[]>> coordinates) {
        setType(type);
        setCoordinates(coordinates);
    }



    public Polygon(Long id, String type, List<List<double[]>> coordinates) {
        setId(id);
        setType(type);
        setCoordinates(coordinates);
    }

    public void setId(long id) { this.id = id; };

    public long getId() {return  id; };

    public void setType(String type) { this.type = type; };

    public String getType() { return type; };

    public void setCoordinates(List<List<double[]>> coordinates) { this.coordinates = coordinates; };

    public List<List<double[]>> getCoordinates() { return coordinates; };
}
