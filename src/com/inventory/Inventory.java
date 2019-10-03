package com.inventory;

import java.util.ArrayList;

interface Inventory {

    String getName();
    void setName(String name);

    ArrayList<ItemImpl> getItems();
    void setItems(ArrayList<ItemImpl> items);

}
