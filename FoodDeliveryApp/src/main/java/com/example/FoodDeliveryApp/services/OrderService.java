package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.EntityNotFoundException;
import com.example.FoodDeliveryApp.entities.Order.OrderDetails;
import com.example.FoodDeliveryApp.entities.Enum.OrderStatus;
import com.example.FoodDeliveryApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public OrderDetails createOrder(OrderDetails order) {
        repository.save(order);
        return order;
    }

    public OrderDetails updateOrderStatus(int id, OrderStatus status) {
        //OrderDetails old_order = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Such orderid  not found"));
        OrderDetails old_order = getOrder(id);
        old_order.setOrderstatus(status);
        repository.save(old_order);
        return old_order;
    }

    public OrderDetails getOrder(int id) {
        return (OrderDetails) repository.findById(id).orElseThrow(() -> new EntityNotFoundException("This id does not exist"));
    }

    public List<OrderDetails> getAllOrdersByUserId(int userId) {
        return (List<OrderDetails>) repository.findAllOrdersByUserId(userId);
    }

    public List<OrderDetails> getAllOrdersByRestaurantId(int restaurantId) {
        return (List<OrderDetails>) repository.findAllOrderByRestaurantId(restaurantId);
    }

    public List<OrderDetails> getAllOrdersByRiderId(int riderId) {
        return (List<OrderDetails>) repository.findAllOrderByRiderId(riderId);

    }
        public List<OrderDetails> getAllOrdersForAdmin()
        {
            return (List<OrderDetails>) repository.findAll();
        }

}


