package com.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InventoryImpl implements Inventory {
    private String name;
    private ArrayList<ItemImpl> items;


    public InventoryImpl() {
        name = "";
        items = new ArrayList<ItemImpl>();
    }

    public InventoryImpl(String nameParam, ArrayList<ItemImpl> itemsParam) {
        name = nameParam;
        items = itemsParam;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) { this.name = name; }

    public ArrayList<ItemImpl> getItems() {
        return this.items;
    }
    public void setItems(ArrayList<ItemImpl> items) {
        this.items = items;

    }

    public static ArrayList<String> searchFacilityInventory(HashMap<String, InventoryImpl> inventories, String id) {
        ArrayList<String> sourceFacilities = new ArrayList<String>();
        Iterator entries = inventories.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            String key = (String) thisEntry.getKey();
            InventoryImpl value = (InventoryImpl) thisEntry.getValue();

            for (ItemImpl item : value.getItems()) {
                if (id.equals(item.getId())) {
                    sourceFacilities.add(key);
                }

            }

        }
        return sourceFacilities;
    }


}
