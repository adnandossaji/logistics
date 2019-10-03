package com.output;

import com.facility.FacilityImpl;
import com.facility.Neighbor;
import com.inventory.InventoryImpl;
import com.inventory.ItemImpl;
import com.order.OrderImpl;
import com.processing.Processing;
import com.travel.Time;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by adnandossaji on 11/3/15.
 */
public interface OrderStatus {

    public static void printos(HashMap<String, ItemImpl> itemsMap, HashMap<String, InventoryImpl> inventoriesMap, OrderImpl orderImpl) throws IOException{

        File directory = new File("orderoutputs");

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

            File file = new File("orderoutputs/" + orderImpl.getId() + ".txt");

            // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            ArrayList<String> directlinks = new ArrayList<String>();
            bw.write("Order #" + orderImpl.getId().substring(3,6) + "\n");

            bw.write("Order Id:          ");
            bw.write(" " + orderImpl.getId() + "\n");

            bw.write("Order Time:        ");
            bw.write(" " + orderImpl.getTime() + "\n");

            bw.write("Destination:       ");
            bw.write(" " + orderImpl.getDestination() + "\n");

            bw.write("A Priority:        ");
            bw.write(" " + orderImpl.getPriority() + "\n");

            bw.write("A List of Order Items: \n");
            bw.write("                   Item ID, " + "Quantity \n");
            for (ItemImpl item : orderImpl.getItems()) {

                bw.write(((String) ("                    " + item.getId() + ", " + item.getQuantity() + " \n")));

            }

            bw.write("\n");

            bw.write("Processing Solution:\n");

            bw.write("Order Id:           ");
            bw.write(" " + orderImpl.getId() + "\n");

            bw.write("Destination:        ");
            bw.write(" " + orderImpl.getDestination() + "\n");

            bw.write("Priority:           ");
            bw.write(" " + orderImpl.getPriority() + "\n");

            int totalCost = 0;
            for (ItemImpl item : orderImpl.getItems()) {
                totalCost += itemsMap.get(item.getId()).getPrice() * item.getQuantity();
            }

            bw.write("Total Cost:         ");
            bw.write(" $" + totalCost + "\n");

            bw.write("1st Delivery Day:   ");
            bw.write(" " + 0 + "\n");

            bw.write("Last Delivery Day:  ");
            bw.write(" " + 0 + "\n");

            bw.write("Order Items:\n");
            bw.write("                   Item ID, " + "Quantity, " + "Cost, " + "Num of Sources, " + "First Day, " + "Last Day\n");
            for (ItemImpl item : orderImpl.getItems()) {
                int cost = itemsMap.get(item.getId()).getPrice() * item.getQuantity();

                bw.write(((String) ("                    " + item.getId() + ", " + item.getQuantity() + ", $" + cost + ", " + Processing.numberOfSources(inventoriesMap, item.getId()) + ", " + 0 + ", " + 0 + " \n")));

            }


            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
