package com.facility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FacilityImplManager {
    private ArrayList<FacilityImpl> facilities;
    private HashMap<String, FacilityImpl> facilitiesMap;

    public FacilityImplManager() {
        ArrayList<FacilityImpl> facilities = new ArrayList<FacilityImpl>();
        HashMap<String, FacilityImpl> facilitiesMap = new HashMap<String, FacilityImpl>();
    }
    public FacilityImplManager(ArrayList<FacilityImpl> facilitiesParam, HashMap<String, FacilityImpl> facilitiesMapParam) {
        facilities = facilitiesParam;
        facilitiesMap = facilitiesMapParam;
    }

    public HashMap<String, FacilityImpl> getFacilitiesMap() { return this.facilitiesMap; }
    public void setFacilitiesMap(HashMap<String, FacilityImpl> facilities) { this.facilitiesMap = facilitiesMap; }

    public ArrayList<FacilityImpl> getFacilities() { return this.facilities; }
    public void setFacilities(ArrayList<FacilityImpl> facilities) { this.facilities = facilities; }

    public Iterator<FacilityImpl> iterator() {
        return facilities.iterator();
    }

}
