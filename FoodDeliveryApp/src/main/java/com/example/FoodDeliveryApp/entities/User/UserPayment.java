package com.example.FoodDeliveryApp.entities.User;

import com.example.FoodDeliveryApp.entities.Enum.PaymentMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;
@Entity
public class UserPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int userPaymentId;
    @NotBlank
    private int userId;
    @NotBlank
    private int orderId;
    @NotBlank
    private double totalAmount;
    @NotBlank
    private double baseAmount;
    @NotBlank
    private double gstAmount;
    private double miscellaneousFee;
    private double deliveryFee;
    private double tip;
    @NotBlank
    private Timestamp timestamp;

    private int transactionId;
    private PaymentMode modeOfPayment;

    public UserPayment() {
    }

    public int getUserPaymentId() {
        return userPaymentId;
    }

    public void setUserPaymentId(int userPaymentId) {
        this.userPaymentId = userPaymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public double getMiscellaneousFee() {
        return miscellaneousFee;
    }

    public void setMiscellaneousFee(double miscellaneousFee) {
        this.miscellaneousFee = miscellaneousFee;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int  getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int  transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentMode getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(PaymentMode  modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
}
