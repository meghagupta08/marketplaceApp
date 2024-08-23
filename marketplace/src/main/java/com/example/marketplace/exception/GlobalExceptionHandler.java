package com.example.marketplace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleUserNotFoundException(UserNotFoundException ex){

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(
                LocalDateTime.now()
                , HttpStatus.NOT_FOUND.value()
                , HttpStatus.NOT_FOUND.getReasonPhrase()
                ,ex.getMessage()
        );
      return  new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);



    }

}
