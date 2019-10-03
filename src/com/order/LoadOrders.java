package com.order;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class LoadOrders {

    public static HashMap<String, OrderImpl> loadOrder(String json) throws IOException {

        File jsonFile = new File(json);

        ObjectMapper mapper = new ObjectMapper();

        OrderImplManager orders = null;

        orders = mapper.readValue(jsonFile, OrderImplManager.class);

        HashMap<String, OrderImpl> orderHashMap = new HashMap<String, OrderImpl>();

        int count = 0;
        Iterator<OrderImpl> orderIterator = orders.iterator();
        while (orderIterator.hasNext()) {
            OrderImpl order = orderIterator.next();
            orderHashMap.put(order.getId(), order);
            count++;
        }


        return orderHashMap;
    }
}