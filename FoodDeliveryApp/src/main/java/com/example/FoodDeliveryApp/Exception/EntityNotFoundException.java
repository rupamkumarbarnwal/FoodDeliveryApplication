package com.example.FoodDeliveryApp.Exception;

public class EntityNotFoundException extends RuntimeException {
    private String msg;

    public EntityNotFoundException() {
        this.msg =msg;
    }

    public EntityNotFoundException(String message) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


