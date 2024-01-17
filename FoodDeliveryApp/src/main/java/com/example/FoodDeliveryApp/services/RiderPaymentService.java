package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.EntityNotFoundException;
import com.example.FoodDeliveryApp.entities.Rider.RiderPayment;
import com.example.FoodDeliveryApp.entities.User.UserPayment;
import com.example.FoodDeliveryApp.repository.RiderPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderPaymentService {
    @Autowired
    RiderPaymentRepository riderPaymentRepository;
    public RiderPayment createRiderPayment(RiderPayment riderPayment){
        riderPaymentRepository.save(riderPayment);
        return riderPayment;
    }
    public RiderPayment getRiderPaymentByRiderId(int riderPaymentId) {
        return (RiderPayment) riderPaymentRepository.findById(riderPaymentId).orElseThrow(() -> new EntityNotFoundException("UserPayment with given id does not exist"));
    }

    public List<RiderPayment> getAllPaymentsByRiderId(int riderId){
        return (List<RiderPayment>) riderPaymentRepository.findAll();
    }

    public RiderPayment getRiderPaymentByTransactionId(int transactionId){
        return riderPaymentRepository.findRiderPaymentByTransactionId(transactionId);

    }
}
