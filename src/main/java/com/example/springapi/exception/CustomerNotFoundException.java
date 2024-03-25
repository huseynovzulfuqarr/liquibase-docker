package com.example.springapi.exception;

public class CustomerNotFoundException extends RuntimeException{
    private final static String MESSAGE="CUSTOMER NOT FOUND";

    public CustomerNotFoundException(){
        super(MESSAGE);
    }
}
