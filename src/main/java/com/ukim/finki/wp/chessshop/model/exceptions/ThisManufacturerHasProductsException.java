package com.ukim.finki.wp.chessshop.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ThisManufacturerHasProductsException extends RuntimeException {
    public ThisManufacturerHasProductsException(Long id) {
        super(String.format("Manufacturer with id %d still has some products left in stock!", id));
    }
}
