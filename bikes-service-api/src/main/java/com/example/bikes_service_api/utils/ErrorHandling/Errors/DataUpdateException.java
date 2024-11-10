package com.example.bikes_service_api.utils.ErrorHandling.Errors;

public class DataUpdateException extends RuntimeException{
    public DataUpdateException(String message){
        super(message);
    }
}
