package com.example.bikes_service_api.utils.ErrorHandling.Errors;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message){
        super(message);
    }
}
