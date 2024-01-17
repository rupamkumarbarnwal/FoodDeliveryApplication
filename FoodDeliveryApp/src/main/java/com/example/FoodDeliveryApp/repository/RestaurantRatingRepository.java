package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRatingRepository extends CrudRepository<RestaurantRating,Integer>{
    public RestaurantRating findByUserIdAndRestaurantId( int userId, int restaurantId);
}
