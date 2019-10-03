package com.order;

import com.inventory.ItemImpl;

import java.util.ArrayList;
import java.util.HashMap;

public interface Order {
    String getId();
    void setId(String id);

    String getTime();
    void setTime(String time);

    String getDestination();
    void setDestination(String destination);

    String getPriority();
    void setPriority(String priority);

    ArrayList<ItemImpl> getItems();
    void setItems(ArrayList<ItemImpl> items);

    HashMap<String, ItemImpl> getItemsMap();
    void setItemsMap(HashMap<String, ItemImpl> itemsMap);

}
