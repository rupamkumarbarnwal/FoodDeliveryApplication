package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.EntityNotFoundException;
import com.example.FoodDeliveryApp.entities.Order.OrderDetails;
import com.example.FoodDeliveryApp.entities.Restaurant.Restaurant;
import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantRating;
import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.repository.RestaurantRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRatingService {
    @Autowired
    RestaurantRatingRepository repository;

    public RestaurantRating  addRestaurantRating(RestaurantRating restaurantRating){
        repository.save(restaurantRating);
        return restaurantRating;
    }
    public  RestaurantRating   getRestaurantRatingByRestaurantId(int restaurantId){
        return (RestaurantRating) repository.findById(restaurantId).orElseThrow(()-> new EntityNotFoundException("This restaurant id does not exist"));
    }

   public  RestaurantRating getRestaurantRatingByUserId(int userId,int restaurantId) {
       RestaurantRating rating = repository.findByUserIdAndRestaurantId(userId, restaurantId);
       return rating;
   }
   public RestaurantRating updateRestaurantRating(int restaurantId,int rating){
       RestaurantRating old_rating  = repository.findById(restaurantId).orElseThrow(() -> new EntityNotFoundException("Restaurant with given id does not exist"));
       old_rating.setRating(rating);

       return old_rating;
   }
   public String deleteRestaurantRating(int restaurantId){
       repository.deleteById(restaurantId);
       return "Restaurant rating deleted successfully";

   }
   }
