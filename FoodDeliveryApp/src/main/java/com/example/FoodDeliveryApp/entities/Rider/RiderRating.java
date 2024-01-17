package com.example.FoodDeliveryApp.entities.Rider;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RiderRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int riderRatingId;
    private int rating;
    @NotBlank
    private int userId;
    @NotBlank
    private int riderId;

    public RiderRating() {
    }

    public int getRiderRatingId() {
        return riderRatingId;
    }

    public void setRiderRatingId(int riderRatingId) {
        this.riderRatingId = riderRatingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }
}
