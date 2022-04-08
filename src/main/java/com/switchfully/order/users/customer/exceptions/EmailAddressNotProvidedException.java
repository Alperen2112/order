package com.switchfully.order.users.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAddressNotProvidedException extends RuntimeException {
    public EmailAddressNotProvidedException() {
        super("Email-address was not provided");
    }
}
