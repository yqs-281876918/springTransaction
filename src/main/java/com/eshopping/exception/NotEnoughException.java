package com.eshopping.exception;

public class NotEnoughException extends RuntimeException
{
    public NotEnoughException() {
        super();
    }
    public NotEnoughException(String message) {
        super(message);
    }
}
