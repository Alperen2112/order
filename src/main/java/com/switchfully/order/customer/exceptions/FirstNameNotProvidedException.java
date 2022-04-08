package com.switchfully.order.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FirstNameNotProvidedException extends RuntimeException {
    public FirstNameNotProvidedException() {super("Firstname was not provided");
    }
}

