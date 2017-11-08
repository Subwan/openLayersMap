package com.openLayersMap.www.Model;


public class Marker {
    private long id;
    private String type;
    private String coordinates;

    public Marker(long id, String type, String coordinates) {
        setId(id);
        setType(type);
        setCoordinates(coordinates);
    }

    public Marker(String type, String coordinates) {
        setType(type);
        setCoordinates(coordinates);
    }

    public void setId(long id) { this.id = id; };

    public long getId() {return  id; };

    public void setType(String type) { this.type = type; };

    public String getType() { return type; };

    public void setCoordinates(String type) { this.coordinates = coordinates; };

    public String getCoordinates() { return coordinates; };
}
