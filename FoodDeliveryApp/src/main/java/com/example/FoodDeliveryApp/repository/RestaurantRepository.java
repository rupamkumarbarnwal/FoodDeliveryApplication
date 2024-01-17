package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Restaurant.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {
}
