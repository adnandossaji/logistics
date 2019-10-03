package com.inventory;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemImplManager {
    private ArrayList<ItemImpl> items = new ArrayList<ItemImpl>();
    private HashMap<String, ItemImpl> itemsMap;

    public ItemImplManager() {
        ArrayList<ItemImpl> items = new ArrayList<ItemImpl>();
        HashMap<String, ItemImpl> itemsMap = new HashMap<String, ItemImpl>();
    }
    public ItemImplManager(ArrayList<ItemImpl> itemsParam, HashMap<String, ItemImpl> itemsMapParam) {
        items = itemsParam;
        itemsMap = itemsMapParam;
    }

    public ArrayList<ItemImpl> getItems() { return this.items; }
    public void setItems(ArrayList<ItemImpl> items) { this.items = items; }

    public HashMap<String, ItemImpl> getItemsMap() { return this.itemsMap; }
    public void setItemsMap(HashMap<String, ItemImpl> items) { this.itemsMap = itemsMap; }

    public Iterator<ItemImpl> iterator() {
        return items.iterator();
    }

}
