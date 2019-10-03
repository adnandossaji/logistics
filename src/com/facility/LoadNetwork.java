package com.facility;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class LoadNetwork {

    public static HashMap<String, FacilityImpl> loadNetwork(String json) throws IOException {

        File jsonFile = new File(json);

        ObjectMapper mapper = new ObjectMapper();

        FacilityImplManager facilities = null;

        facilities = mapper.readValue(jsonFile, FacilityImplManager.class);

        HashMap<String, FacilityImpl> facilityHashMap = new HashMap<String, FacilityImpl>();

        int count = 0;
        Iterator<FacilityImpl> facilityIterator = facilities.iterator();
        while (facilityIterator.hasNext()) {
            FacilityImpl facility = facilityIterator.next();
            facilityHashMap.put(facility.getName(), facility);
            count++;
        }


        return facilityHashMap;
    }

}