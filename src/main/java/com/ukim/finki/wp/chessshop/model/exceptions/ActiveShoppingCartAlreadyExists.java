package com.ukim.finki.wp.chessshop.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ActiveShoppingCartAlreadyExists extends RuntimeException {
}
