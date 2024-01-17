package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Rider.RiderPayment;
import com.example.FoodDeliveryApp.entities.User.UserPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderPaymentRepository  extends CrudRepository<RiderPayment,Integer>{
    public RiderPayment findRiderPaymentByTransactionId(int  transactionId);
}
