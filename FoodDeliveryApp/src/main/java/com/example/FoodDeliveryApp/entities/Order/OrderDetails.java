package com.example.FoodDeliveryApp.entities.Order;

import com.example.FoodDeliveryApp.entities.Enum.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @NotBlank
    private int userId;

    public OrderDetails() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public OrderStatus getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(OrderStatus orderstatus) {
        this.orderstatus = orderstatus;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Timestamp getOrderPlacedTimeStamp() {
        return orderPlacedTimeStamp;
    }

    public void setOrderPlacedTimeStamp(Timestamp orderPlacedTimeStamp) {
        this.orderPlacedTimeStamp = orderPlacedTimeStamp;
    }

    public Timestamp getOrderDeliveredTimeStamp() {
        return orderDeliveredTimeStamp;
    }

    public void setOrderDeliveredTimeStamp(Timestamp orderDeliveredTimeStamp) {
        this.orderDeliveredTimeStamp = orderDeliveredTimeStamp;
    }



    private int restaurantId;
    private int riderId;
    private OrderStatus orderstatus;
    private int addressId;
    private Timestamp orderPlacedTimeStamp;
    private Timestamp orderDeliveredTimeStamp;

}
