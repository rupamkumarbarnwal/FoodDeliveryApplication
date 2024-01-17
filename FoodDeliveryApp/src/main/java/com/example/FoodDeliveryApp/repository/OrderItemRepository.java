package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Order.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {
}
