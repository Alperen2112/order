package com.switchfully.order.customer;

import com.switchfully.order.customer.dtos.CustomerDto;
import com.switchfully.order.customer.dtos.RegisterCustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto registerCustomer (@RequestBody RegisterCustomerDto registerCustomerDto) {
        return customerService.registerMember(registerCustomerDto);
    }


}
