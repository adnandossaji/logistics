package com.facility;

import com.inventory.InventoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Integer;

public class FacilityImpl implements Facility {
    private int id;
    private String name;
    private int rate;
    private int cost;
    private ArrayList<NeighborImpl> neighbors;

    public FacilityImpl() {
        id = 0;
        name = "";
        rate = 0;
        cost = 0;
        neighbors = new ArrayList<NeighborImpl>();
    }

    public FacilityImpl(int idParam, String nameParam, int rateParam, int costParam, ArrayList<NeighborImpl> neighborsParam, ArrayList<InventoryImpl> inventoryParam, HashMap<Integer, Integer> scheduleParam) {
        id = idParam;
        name = nameParam;
        rate = rateParam;
        cost = costParam;
        neighbors = neighborsParam;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) { this.name = name; }

    public int getRate() {
        return this.rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }

    public ArrayList<NeighborImpl> getNeighbors() {
        return this.neighbors;
    }
    public void setNeighbors(ArrayList<NeighborImpl> neighbors) {
        this.neighbors = neighbors;
    }

    public int getCost() {
        return this.cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

}
