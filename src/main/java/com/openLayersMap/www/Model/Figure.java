package com.openLayersMap.www.Model;

/**
 * Class of the figures.
 */
public class Figure {
    private long id;
    private String coordinates;

    /**
     * This constructor uses when figures is update.
     * @param id
     * @param coordinates
     */
    public Figure(long id, String coordinates) {
        setId(id);
        setCoordinates(coordinates);
    }

    /**
     * This constructor uses when figures is insert.
     * @param coordinates
     */
    public Figure(String  coordinates) {
        setCoordinates(coordinates);
    }

    /**
     * This constructor uses to create object from data base.
     * @param id
     * @param coordinates
     */
    public Figure(Long id, String coordinates) {
        setId(id);
        setCoordinates(coordinates);
    }

    public void setId(long id) { this.id = id; };

    public long getId() {return  id; };

    public void setCoordinates(String coordinates) { this.coordinates = coordinates; };

    public String getCoordinates() { return coordinates; };

}
