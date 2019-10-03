package com.schedule;

import com.facility.FacilityImpl;
import com.inventory.InventoryImpl;
import com.inventory.ItemImpl;
import com.order.LoadOrders;
import com.order.OrderImpl;
import com.shortestpath.ShortestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by H. Simba on 11/16/2015.
 */
public class ScheduleImpl {
    private HashMap<Integer, Integer> schedule;

    public static HashMap<String, HashMap<Integer, Integer>> createSchedule(HashMap<String, FacilityImpl> facilities, HashMap<String, InventoryImpl> inventories, HashMap<String, OrderImpl> orders) {
        ArrayList<String> itemList = new ArrayList<String>();
        HashMap<String, ArrayList<String>> sourceFacilities = new HashMap<String, ArrayList<String>>();
        HashMap<String, HashMap<Integer, Integer>> schedulesMap = new HashMap<String, HashMap<Integer, Integer>>();

        Iterator entries = orders.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            String key = (String) thisEntry.getKey();
            OrderImpl value = (OrderImpl) thisEntry.getValue();

            for (ItemImpl item : value.getItems()) {
                sourceFacilities.put(item.getId(), InventoryImpl.searchFacilityInventory(inventories, item.getId()));
                System.out.println(item.getId() + " - " + item.getQuantity() + " - " + sourceFacilities.get(item.getId()));
//                this.schedule = new HashMap<Integer, Integer>();
                HashMap<Integer, Integer> schedule = new HashMap<Integer, Integer>();
                int itemQuantityLimit = item.getQuantity();
                for (String facilityName : sourceFacilities.get(item.getId())) {
                    System.out.println(facilityName);
                    System.out.println("Rate: " + facilities.get(facilityName).getRate());

                    for (ItemImpl facilityItem : inventories.get(facilityName).getItems()) {
                        if (facilityItem.getId().equals(item.getId())) {
                            System.out.print("Quantity: " + facilityItem.getQuantity() + "\n");
                            schedule = scheduler(schedule, facilities.get(facilityName).getRate(), facilityItem.getQuantity(), item.getQuantity());
                            System.out.println(schedule);
                            schedulesMap.put(facilityName, schedule);
//                            ShortestPath.shortestPath(facilities, facilityName, value.getDestination());
                            System.out.println();
                        }

                    }

                }
            }
        }

        return schedulesMap;
    }

    public static HashMap<Integer, Integer> scheduler(HashMap<Integer, Integer> schedule, int rate, int quantity, int itemQuantityLimit) {
        int day = 0;
        while (itemQuantityLimit > 0) {
            if (rate < quantity) {
                schedule.put(day, rate);
                quantity -= rate;
                itemQuantityLimit -=rate;
                day++;
            } else {
                schedule.put(day, quantity);
                quantity -= quantity;
                itemQuantityLimit -= rate;
                day++;
            }
        }

        return schedule;
    }

}
