package com.dstryzhov.ae.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoTransactionFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "No transaction with given UUID found";
    }
}
