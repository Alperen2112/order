package com.switchfully.order.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PhoneNumberNotProvidedException extends RuntimeException {
    public PhoneNumberNotProvidedException() {super("Phonenumber was not provided");
    }
}
