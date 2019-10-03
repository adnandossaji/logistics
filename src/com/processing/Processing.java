package com.processing;

import com.facility.FacilityImpl;
import com.inventory.InventoryImpl;
import com.inventory.ItemImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Processing {
    String orderId;
    String destination;
    String priority;
    int totalCost;
    int firstDeliveryDay;
    int lastDeliveryDay;
    ArrayList<FacilityImpl> sourceFacilities;

    public static int calculateCost(int quantity, int price) {
        int cost = quantity * price;
        return cost;
    }

    // May not be ArrayList for inventories
    public static int numberOfSources(HashMap<String, InventoryImpl> inventories, String id) {
        int count = 0;

        Iterator entries = inventories.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            String key = (String) thisEntry.getKey();
            InventoryImpl value = (InventoryImpl) thisEntry.getValue();

            ArrayList<ItemImpl> facilityInventory = value.getItems();
            for (ItemImpl item : facilityInventory) {
                if (item.getId().equals(id)) {
                    count++;
                }
            }
        }

        return count;
    }
}
