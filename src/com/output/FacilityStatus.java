package com.output;

import com.facility.*;
import com.inventory.InventoryImpl;
import com.inventory.ItemImpl;
import com.travel.Time;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by adnandossaji on 11/3/15.
 */
public interface FacilityStatus {

    public static void printfs(HashMap<String, HashMap<Integer, Integer>> schedulesMap, FacilityImpl facilityImpl, InventoryImpl inventory, HashMap<String, ItemImpl> itemsMap) throws IOException{

        File directory = new File("facilityoutputs");

        try {

            if (!directory.exists()) {
                boolean result = false;

                try{
                    directory.mkdir();
                    result = true;
                }
                catch(SecurityException se){
                    //handle it
                }
                if(result) {
                    System.out.println("DIR created");
                }
            }

            File file = new File("facilityoutputs/" + facilityImpl.getName() + ".txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            ArrayList<String> directlinks = new ArrayList<String>();
            bw.write(facilityImpl.getName() + "\n");

            bw.write("Direct Links:     ");

            for (Neighbor neighbor : facilityImpl.getNeighbors()) {
                float traveltime = Time.travelTime(neighbor.getDistance());
                directlinks.add(neighbor.getName() + " (" + traveltime + "d)");
//                Time.travelTime();
            }

            bw.write(" " + directlinks + "\n");

            bw.write("Active Inventory: \n");

            bw.write("                   Item ID, " + "Quantity \n");

            ArrayList<String> depletedItems = new ArrayList<>();
            Iterator entries = itemsMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry thisEntry = (Map.Entry) entries.next();
                String key = (String) thisEntry.getKey();
                ItemImpl value = (ItemImpl) thisEntry.getValue();

                depletedItems.add(key);

            }

            for (ItemImpl item : inventory.getItems()) {

                bw.write(((String) ("                    " + item.getId() + ", " + item.getQuantity() + " \n")));
                depletedItems.remove(item.getId());

            }

            bw.write("Depleted Items:   " + depletedItems.toString() + "\n");
            bw.write("Schedule:         ");
            bw.write(schedulesMap.get(facilityImpl.getName()).toString());

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
