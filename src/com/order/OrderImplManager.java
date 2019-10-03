package com.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class OrderImplManager {
    private ArrayList<OrderImpl> orders;
    private HashMap<String, OrderImpl> ordersMap;

    public OrderImplManager() {
        ArrayList<OrderImpl> orders = new ArrayList<OrderImpl>();
        HashMap<String, OrderImpl> ordersMap = new HashMap<String, OrderImpl>();
    }
    public OrderImplManager(ArrayList<OrderImpl> ordersParam, HashMap<String, OrderImpl> ordersMapParam) {
        orders = ordersParam;
        ordersMap = ordersMapParam;
    }

    public ArrayList<OrderImpl> getOrders() { return this.orders; }
    public void setOrders(ArrayList<OrderImpl> orders) { this.orders = orders; }

    public HashMap<String, OrderImpl> getOrdersMap() { return this.ordersMap; }
    public void setOrdersMap(HashMap<String, OrderImpl> ordersMap) { this.ordersMap = ordersMap; }

    public Iterator<OrderImpl> iterator() {
        return orders.iterator();
    }

}
