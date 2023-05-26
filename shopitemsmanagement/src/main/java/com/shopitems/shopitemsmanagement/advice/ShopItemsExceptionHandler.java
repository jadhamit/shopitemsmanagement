package com.shopitems.shopitemsmanagement.advice;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ShopItemsExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity handleDataAccessException(
            Exception ex) {
        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
    }
}