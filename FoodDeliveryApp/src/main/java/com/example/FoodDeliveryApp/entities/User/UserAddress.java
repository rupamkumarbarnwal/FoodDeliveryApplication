package com.example.FoodDeliveryApp.entities.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
// We don't need to pass id as it is autogenerated
    private int addressId;

    @NotBlank
    private String city;
    @NotBlank
    private String address;
    @NotBlank
    private String state;
    @NotBlank
    private int  pinCode;
    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName = "userId")
    private User user;

    public UserAddress() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int  pinCode) {
        this.pinCode = pinCode;
    }
}
