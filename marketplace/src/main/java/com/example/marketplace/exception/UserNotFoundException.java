package com.example.marketplace.exception;

public class UserNotFoundException extends RuntimeException{

    private String messsage;
    private String cause;

    public UserNotFoundException(String messsage){
        super(messsage);
    }
}
