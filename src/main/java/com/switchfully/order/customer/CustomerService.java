package com.switchfully.order.customer;

import com.switchfully.order.customer.dtos.CustomerDto;
import com.switchfully.order.customer.dtos.RegisterCustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto registerMember(RegisterCustomerDto registerCustomerDto) {
        Customer customer = customerMapper.ToCustomer(registerCustomerDto);
        Customer savedCustomer = customerRepository.addCustomer(customer);

        return customerMapper.toDto(savedCustomer);




    }
}