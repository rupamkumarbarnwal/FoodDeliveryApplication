package com.example.FoodDeliveryApp.entities.Rider;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;
@Entity
public class RiderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int riderPaymentId;
    @NotBlank
    private int riderId;
    @NotBlank
    private double amount;
    private int transactionId;
    @NotBlank
    private Timestamp timestamp;

    public RiderPayment() {
    }

    public int getRiderPaymentId() {
        return riderPaymentId;
    }

    public void setRiderPaymentId(int riderPaymentId) {
        this.riderPaymentId = riderPaymentId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
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
