package com.facility;

import java.util.ArrayList;
import java.util.HashMap;

public class NeighborImplManager {
    private ArrayList<NeighborImpl> neighbors;
    private HashMap<String, NeighborImpl> neighborsMap;

    public NeighborImplManager() {
        ArrayList<NeighborImpl> neighbors = new  ArrayList<NeighborImpl>();
        HashMap<String, NeighborImpl> neighborsMap = new HashMap<String, NeighborImpl>();
    }
    public NeighborImplManager(ArrayList<NeighborImpl> neighborsParam, HashMap<String, NeighborImpl> neighborsMapParam) {
        neighbors = neighborsParam;
        neighborsMap = neighborsMapParam;
    }

    public ArrayList<NeighborImpl> getNeighbors() { return this.neighbors; }
    public void setNeighbors(ArrayList<NeighborImpl> neighbors) {
        this.neighbors = neighbors;
    }

    public HashMap<String, NeighborImpl> getNeighborsMap() { return this.neighborsMap; }
    public void setNeighborsMap(HashMap<String, NeighborImpl> neighborsMap) {
        this.neighborsMap = neighborsMap;
    }
}
