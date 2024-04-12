package com.leavetracker.exception;

public class ConcreteErrorResponse extends ErrorResponse{
    public ConcreteErrorResponse(int status, String message) {
        super(status, message);
    }
}
