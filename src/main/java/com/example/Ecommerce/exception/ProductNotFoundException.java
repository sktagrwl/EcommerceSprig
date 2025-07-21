package com.example.Ecommerce.exception;

public class ProductNotFoundException extends RuntimeException{


    public ProductNotFoundException(String message){
        super(message);
    }
}

//Why extend RunTimeException?

//Mark it an unchecked exception. Callers are not forced to declare or catch it.
