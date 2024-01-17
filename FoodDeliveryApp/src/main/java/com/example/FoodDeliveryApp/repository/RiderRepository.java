package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Rider.Rider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends CrudRepository<Rider,Integer> {
}
