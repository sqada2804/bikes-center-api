package com.example.bikes_service_api.utils.ErrorHandling.Errors;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String message){
        super(message);
    }
}
