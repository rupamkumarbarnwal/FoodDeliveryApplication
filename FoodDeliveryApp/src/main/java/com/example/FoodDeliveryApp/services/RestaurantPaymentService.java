package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.EntityNotFoundException;
import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantPayment;
import com.example.FoodDeliveryApp.entities.User.UserPayment;
import com.example.FoodDeliveryApp.repository.RestaurantPaymentRepository;
import com.example.FoodDeliveryApp.repository.UserPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantPaymentService {
    @Autowired
    RestaurantPaymentRepository paymentRepository;
    public RestaurantPayment createRestaurantPayment(RestaurantPayment restaurantPayment){
        paymentRepository.save(restaurantPayment);
        return restaurantPayment;
    }
    public RestaurantPayment getPaymentByRestaurantId(int restaurantPaymentId) {
        return (RestaurantPayment) paymentRepository.findById(restaurantPaymentId).orElseThrow(() -> new EntityNotFoundException("UserPayment with given id does not exist"));
    }

    public List<RestaurantPayment> getAllPaymentsByRestaurantId(int restaurantId){
        return (List<RestaurantPayment>) paymentRepository.findAll();
    }


    public RestaurantPayment getRestaurantPaymentByTransactionId(int  transactionId){
        return paymentRepository.findRestaurantPaymentByTransactionId(transactionId);
    }
}
