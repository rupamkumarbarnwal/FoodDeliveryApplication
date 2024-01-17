package com.example.FoodDeliveryApp.entities.Rider;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;
@Entity
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int riderId;
    @NotBlank
    private String name;
    @NotBlank
    private String city;
    @NotBlank
    private String address;
    private Date dob;
    @NotBlank
    private  String state;
    @NotBlank
    private  int pincode;
    @NotBlank
    private String phoneNumber;
    //profile pic
    private byte[] profilePic;
    private String mail;
    @NotBlank
    private String password;
    //Dl
    //bankAccountDetails
    // Enum - Vechile Type
    @NotBlank
    private String vechile;
    @NotBlank
    private double latittude;
    @NotBlank
    private double longitude;
    @NotBlank
    private boolean isAvailable;

    public Rider() {
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVechile() {
        return vechile;
    }

    public void setVechile(String vechile) {
        this.vechile = vechile;
    }

    public double getLatittude() {
        return latittude;
    }

    public void setLatittude(double latittude) {
        this.latittude = latittude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }
}
