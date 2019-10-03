package com.inventory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class LoadInventory {

    public static HashMap<String, InventoryImpl> loadInventory(String json) throws IOException {

        File jsonFile = new File(json);

        ObjectMapper mapper = new ObjectMapper();

        InventoryImplManager inventories = null;

        inventories = mapper.readValue(jsonFile, InventoryImplManager.class);

        HashMap<String, InventoryImpl> inventoryHashMap = new HashMap<String, InventoryImpl>();

        int count = 0;
        Iterator<InventoryImpl> inventoryIterator = inventories.iterator();
        while (inventoryIterator.hasNext()) {
            InventoryImpl inventory = inventoryIterator.next();
            inventoryHashMap.put(inventory.getName(), inventory);
            count++;
        }


        return inventoryHashMap;
    }
}
