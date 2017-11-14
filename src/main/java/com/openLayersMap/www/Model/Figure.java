package com.openLayersMap.www.Model;


public class Figure {
    private long id;
    private String coordinates;

    public Figure(long id, String coordinates) {
        setId(id);
        setCoordinates(coordinates);
    }

    public Figure(String  coordinates) {
        setCoordinates(coordinates);
    }


    public Figure(Long id, String coordinates) {
        setId(id);
        setCoordinates(coordinates);
    }

    public void setId(long id) { this.id = id; };

    public long getId() {return  id; };

    public void setCoordinates(String coordinates) { this.coordinates = coordinates; };

    public String getCoordinates() { return coordinates; };

}
