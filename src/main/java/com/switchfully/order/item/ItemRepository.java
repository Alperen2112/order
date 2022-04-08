package com.switchfully.order.item;

import com.switchfully.order.customer.Customer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    public final ConcurrentHashMap<String, Item> itemsDatabase = new ConcurrentHashMap<>();

    public Item addItem(Item item) {
        itemsDatabase.put(item.getId(), item);
        return itemsDatabase.get(item.getId());
    }
}
