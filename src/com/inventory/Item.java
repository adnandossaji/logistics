package com.inventory;

import java.util.ArrayList;

/**
 * Created by adnandossaji on 11/11/15.
 */
public interface Item {

    public String getId();
    public void setId(String id);

    public int getPrice();
    public void setPrice(int price);

    public int getQuantity();
    public void setQuantity(int quantity);
}
