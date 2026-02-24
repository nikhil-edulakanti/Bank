package com.nikki.bank.exceptions;


import com.nikki.bank.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomerExceptions.class)
    public ResponseEntity<APIResponse> handleCustomerExceptions(CustomerExceptions e) {
        String message =e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(message, false));
    }
}
