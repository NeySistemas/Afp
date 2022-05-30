package com.management.afp.exception;

public class ModeloBadRequestException extends RuntimeException{
    public ModeloBadRequestException(String mensaje){
        super(mensaje);
    }
}
