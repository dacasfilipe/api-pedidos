package com.pedidos.api.exceptions;



public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {

        super(message);

    }

}