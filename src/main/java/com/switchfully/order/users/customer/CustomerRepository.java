package com.switchfully.order.users.customer;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {

    public final ConcurrentHashMap<String,Customer> customersDatabase = new ConcurrentHashMap<>();

    public Customer addCustomer(Customer customer) {
        customersDatabase.put(customer.getId(), customer);
        return customersDatabase.get(customer.getId());
    }
}
