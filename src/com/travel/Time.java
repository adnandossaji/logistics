package com.travel;

import com.facility.FacilityImpl;
import com.facility.FacilityImplManager;
import com.facility.NeighborImpl;

import java.util.*;

/**
 * Created by adnandossaji on 11/3/15.
 */
public class Time {
    private static float distance;
    private int hours;
    private int mph;

    public static float travelTime(float distance) {
        int hours = 8;
        int mph= 50;

        float travelTime = distance / (hours * mph);

        return travelTime;
    }

    public static int calculateDistance(HashMap<String, FacilityImpl> facilities, LinkedList<Integer> list) {
        int distance = 0;

        int prev = -1;

        for (int vert : list) {

            Iterator entries = facilities.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry thisEntry = (Map.Entry) entries.next();
                String key = (String) thisEntry.getKey();
                FacilityImpl value = (FacilityImpl) thisEntry.getValue();
                Iterator<NeighborImpl> itr2 = value.getNeighbors().iterator();
                while (itr2.hasNext()) {
                    NeighborImpl element2 = itr2.next();

                    if (value.getId() == prev && element2.getId() == vert) {
                        distance += element2.getDistance();
                    }

                }
            }

            prev = vert;
        }

        return distance;

    }

}
