package com.facility;

import java.util.ArrayList;

public class NeighborImpl implements Neighbor {
    private int id;
    private String name;
    private int distance;

    public NeighborImpl(){
        id = 0;
        name = "";
        distance = 0;
    }

    public NeighborImpl(int idParam, String nameParam, int distanceParam){
        id = idParam;
        name = nameParam;
        distance = distanceParam;
    }

    public int getId() {return this.id;}
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return this.distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
}
