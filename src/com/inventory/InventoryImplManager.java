package com.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class InventoryImplManager {
    private ArrayList<InventoryImpl> inventories;
    private HashMap<String, InventoryImpl> inventoriesMap;

    public InventoryImplManager() {
        ArrayList<InventoryImpl> inventories = new ArrayList<InventoryImpl>();
        HashMap<String, InventoryImpl> inventoriesMap = new HashMap<String, InventoryImpl>();
    }
    public InventoryImplManager(ArrayList<InventoryImpl> inventoriesParam, HashMap<String, InventoryImpl> inventoriesMapParam) {
        inventories = inventoriesParam;
        inventoriesMap = inventoriesMapParam;
    }

    public HashMap<String, InventoryImpl> getInventoriesMap() { return this.inventoriesMap; }
    public void setInventoriesMap(HashMap<String, InventoryImpl> inventories) { this.inventoriesMap = inventoriesMap; }

    public ArrayList<InventoryImpl> getInventories() { return this.inventories; }
    public void setInventories(ArrayList<InventoryImpl> inventories) { this.inventories = inventories; }

    public Iterator<InventoryImpl> iterator() {
        return inventories.iterator();
    }

}
