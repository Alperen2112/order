package com.switchfully.order.users.customer;

import com.switchfully.order.users.customer.dtos.CustomerDto;
import com.switchfully.order.users.customer.dtos.RegisterCustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {


    public Customer ToCustomer(RegisterCustomerDto registerCustomerDto) {
        return new Customer(
                registerCustomerDto.getFirstName(),
                registerCustomerDto.getLastName(),
                registerCustomerDto.getEmailAddress(),
                registerCustomerDto.getAddress(),
                registerCustomerDto.getPhoneNumber());
    }

    public CustomerDto toDto(Customer savedCustomer) {
        return new CustomerDto(savedCustomer.getId(),
                savedCustomer.getFirstName(),
                savedCustomer.getLastName(),
                savedCustomer.getEmailAddress(),
                savedCustomer.getAddress(),
                savedCustomer.getPhoneNumber());
    }
}
