package com.order;

import com.inventory.ItemImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderImpl implements Order {
    private String id;
    private String time;
    private String destination;
    private String priority;
    private ArrayList<ItemImpl> items;
    private HashMap<String, ItemImpl> itemsMap;

    public OrderImpl(){
        id = "";
        time = "";
        destination = "";
        priority = "";
        items = new ArrayList<ItemImpl>();
        itemsMap = new HashMap<String, ItemImpl>();
    }

    public OrderImpl(String idParam, OrderImpl orderParam, String timeParam, String destinationParam, String priorityParam, ArrayList<ItemImpl> itemsParam, HashMap<String, ItemImpl> itemsMapParam ){
        id = idParam;
        time = timeParam;
        destination = destinationParam;
        priority = priorityParam;
        items = itemsParam;
        itemsMap = itemsMapParam;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return this.time;
    }
    public void setTime(String time) { this.time = time; }

    public String getDestination() { return this.destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getPriority() {
        return this.priority;
    }
    public void setPriority(String priority) { this.priority = priority; }

    public ArrayList<ItemImpl> getItems() { return this.items; }
    public void setItems(ArrayList<ItemImpl> items) { this.items = items; }

    public HashMap<String, ItemImpl> getItemsMap() { return this.itemsMap; }
    public void setItemsMap(HashMap<String, ItemImpl> itemsMap) { this.itemsMap = itemsMap; }



}
