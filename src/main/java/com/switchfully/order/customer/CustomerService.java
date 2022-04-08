package com.switchfully.order.customer;

import com.switchfully.order.customer.dtos.CustomerDto;
import com.switchfully.order.customer.dtos.RegisterCustomerDto;
import com.switchfully.order.customer.exceptions.*;
import com.switchfully.order.customer.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto registerMember(RegisterCustomerDto registerCustomerDto) {
        logger.info("Registering a new Customer");

        validateRegisterCustomerDto(registerCustomerDto);

        Customer customer = customerMapper.ToCustomer(registerCustomerDto);
        Customer savedCustomer = customerRepository.addCustomer(customer);

        logger.info("New customer has been registered");
        return customerMapper.toDto(savedCustomer);


    }

    private void validateRegisterCustomerDto(RegisterCustomerDto registerCustomerDto) {
        checkForNullBlankOrEmptyExceptions(registerCustomerDto.getFirstName(), new FirstNameNotProvidedException());
        checkForNullBlankOrEmptyExceptions(registerCustomerDto.getLastName(), new LastNameNotProvidedException());
        checkForNullBlankOrEmptyExceptions(registerCustomerDto.getEmailAddress(), new EmailAddressNotProvidedException());
        checkForNullBlankOrEmptyExceptions(registerCustomerDto.getAddress(), new AddressNotProvidedException());
        checkForNullBlankOrEmptyExceptions(registerCustomerDto.getPhoneNumber(), new PhoneNumberNotProvidedException());
    }


    private void checkForNullBlankOrEmptyExceptions(String stringToCheck, RuntimeException ex) {
        if (isNullBlankOrEmpty(stringToCheck)) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }

    private boolean isNullBlankOrEmpty(String stringToCheck) {
        return stringToCheck == null || stringToCheck.isEmpty() || stringToCheck.isBlank();
    }
}