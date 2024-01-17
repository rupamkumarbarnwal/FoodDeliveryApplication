package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantPaymentRepository extends CrudRepository<RestaurantPayment, Integer> {
    public RestaurantPayment findRestaurantPaymentByTransactionId(int  transactionId);

}
