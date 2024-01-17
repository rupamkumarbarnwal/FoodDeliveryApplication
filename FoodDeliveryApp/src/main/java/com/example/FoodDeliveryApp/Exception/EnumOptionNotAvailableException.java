package com.example.FoodDeliveryApp.Exception;

public class EnumOptionNotAvailableException extends RuntimeException{
    private String msg;


    public EnumOptionNotAvailableException(String message) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
