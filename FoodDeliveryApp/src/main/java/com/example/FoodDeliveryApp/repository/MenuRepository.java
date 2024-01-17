package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Restaurant.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Integer> {
}
