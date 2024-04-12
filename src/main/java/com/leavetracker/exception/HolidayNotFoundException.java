package com.leavetracker.exception;

public class HolidayNotFoundException extends RuntimeException{
    private String message;

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public HolidayNotFoundException(){
    }
    public HolidayNotFoundException(String message){
        this.message =message;
    }


}
