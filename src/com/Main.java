package com;

//import com.graph.*;

import com.facility.FacilityImpl;
import com.facility.LoadNetwork;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.inventory.*;
import com.order.LoadOrders;
import com.order.Order;
import com.order.OrderImpl;
import com.output.FacilityStatus;
import com.output.OrderStatus;
import com.processing.Processing;
import com.schedule.ScheduleImpl;

import java.io.IOException;
import java.util.*;


public class Main {

//    private static List<Vertex> nodes;
//    private static List<Edge> edges;

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        HashMap<String, FacilityImpl> facilities = LoadNetwork.loadNetwork("facility.json");
//        System.out.println(facilities.get("Chicago, IL").getNeighbors().get(0).getName());
//        System.out.println(facilities.get("New York City, NY").getId());
//
        HashMap<String, InventoryImpl> inventories = LoadInventory.loadInventory("facilityinventory.json");
//        System.out.println(inventories.get("Chicago, IL").getItems().get(0).getId());
//
        HashMap<String, ItemImpl> items = LoadItems.loadItems("items.json");
//        System.out.println(items.get("ABC123").getPrice());
//
//        HashMap<String, OrderImpl> orders = LoadOrders.loadOrder("order.json");
//        System.out.println(orders.get("TO-001").getDestination());

        HashMap<String, OrderImpl> orders = LoadOrders.loadOrder("order.json");

        HashMap<String, HashMap<Integer, Integer>> schedule = ScheduleImpl.createSchedule(facilities, inventories, orders);

        Iterator entries = facilities.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            String key = (String) thisEntry.getKey();
            FacilityImpl value = (FacilityImpl) thisEntry.getValue();

            FacilityStatus.printfs(schedule, facilities.get(value.getName()), inventories.get(value.getName()), items);
        }

        HashMap<String, HashMap> schedules = new HashMap<String, HashMap>();

        Iterator entries2 = orders.entrySet().iterator();
        while (entries2.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries2.next();
            String key = (String) thisEntry.getKey();
            OrderImpl value = (OrderImpl) thisEntry.getValue();

            OrderStatus.printos(items, inventories, orders.get(value.getId()));
        }

    }
}