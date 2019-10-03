package com.inventory;

import java.util.ArrayList;

public class ItemImpl implements Item {
    private String id;
    private int price;
    private int quantity;

    public ItemImpl() {
        id = "";
        price = 0;
        quantity = 0;
    }

    public ItemImpl(String idParam, int priceParam, int quantityParam) {
        id = idParam;
        price = priceParam;
        quantity = quantityParam;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) { this.id = id; }

    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) { this.price = price; }

    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) { this.quantity = quantity; }


}
