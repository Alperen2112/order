package com.switchfully.order.users.customer.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LastNameNotProvidedException extends RuntimeException {
    public LastNameNotProvidedException() {super("Lastname was not provided");
    }
}
