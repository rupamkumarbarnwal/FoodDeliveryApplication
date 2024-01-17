package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.InvalidDataException;
import com.example.FoodDeliveryApp.entities.Restaurant.Menu;
import com.example.FoodDeliveryApp.entities.Restaurant.Restaurant;
import com.example.FoodDeliveryApp.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    RestaurantRepository repository;
    public Restaurant createRestaurant(Restaurant restaurant){
        repository.save(restaurant);
        return restaurant;
    }
    public Restaurant getRestaurant(int id){
        return (Restaurant) repository.findById(id).orElseThrow(()-> new InvalidDataException("Restaurant with such id does not exist"));
    }
    public Restaurant updateRestaurant(Restaurant restaurant){
       Restaurant old_restaurant = getRestaurant(restaurant.getRestaurantId());
        if(restaurant.getName()==null|| restaurant.getPhoneNumber()==null || restaurant.getPassword()==null) {
            throw new InvalidDataException("Restaurant id or phoneNumber or password cannot be null");
        }
        old_restaurant.setName(restaurant.getName());
        old_restaurant.setLatitude(restaurant.getLatitude());
        old_restaurant.setLongitude(restaurant.getLongitude());
        old_restaurant.setCity(restaurant.getCity());
        old_restaurant.setAddress(restaurant.getAddress());
        old_restaurant.setState(restaurant.getState());
        old_restaurant.setPincode(restaurant.getPincode());
        old_restaurant.setWebsite(restaurant.getWebsite());
        old_restaurant.setGst(restaurant.getGst());
        old_restaurant.setFssaiStatus(restaurant.getFssaiStatus());
        old_restaurant.setEmail(restaurant.getEmail());
        old_restaurant.setPassword(restaurant.getPassword());
        old_restaurant.setApproved(restaurant.isApproved());
        return old_restaurant;
    }

    public String deleteRestaurant(int restaurantId){
        repository.deleteById(restaurantId);
        return "Restaurant  with given id is deleted successfully";
    }


}
