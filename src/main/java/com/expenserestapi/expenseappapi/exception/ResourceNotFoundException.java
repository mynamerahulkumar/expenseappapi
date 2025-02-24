package com.expenserestapi.expenseappapi.exception;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
