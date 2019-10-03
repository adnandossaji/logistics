package com.inventory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class LoadItems {

    public static HashMap<String, ItemImpl> loadItems(String json) throws IOException {

        File jsonFile = new File(json);

        ObjectMapper mapper = new ObjectMapper();

        ItemImplManager items = null;

        items = mapper.readValue(jsonFile, ItemImplManager.class);

        HashMap<String, ItemImpl> itemsHashMap = new HashMap<String, ItemImpl>();

        int count = 0;
        Iterator<ItemImpl> itemsIterator = items.iterator();
        while (itemsIterator.hasNext()) {
            ItemImpl item = itemsIterator.next();
            itemsHashMap.put(item.getId(), item);
            count++;
        }


        return itemsHashMap;
    }
}
