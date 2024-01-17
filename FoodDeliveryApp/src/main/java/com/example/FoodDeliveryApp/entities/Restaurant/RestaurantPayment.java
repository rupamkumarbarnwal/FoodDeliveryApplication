package com.example.FoodDeliveryApp.entities.Restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;
@Entity
public class RestaurantPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurantPaymentId;
    @NotBlank
    private int restaurantId;
    @NotBlank
    private double amount;
    private int transactionId;
    @NotBlank
    private Timestamp timestamp;

    public RestaurantPayment() {
    }

    public int getRestaurantPaymentId() {
        return restaurantPaymentId;
    }

    public void setRestaurantPaymentId(int restaurantPaymentId) {
        this.restaurantPaymentId = restaurantPaymentId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
