package com.example.FoodDeliveryApp.entities.Restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RestaurantRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int restaurantRatingId;
    @NotBlank
    private int restaurantId;
    @NotBlank
    private int userId;

    private int rating;

    public RestaurantRating() {
    }

    public int getRestaurantRatingId() {
        return restaurantRatingId;
    }

    public void setRestaurantRatingId(int restaurantRatingId) {
        this.restaurantRatingId = restaurantRatingId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
