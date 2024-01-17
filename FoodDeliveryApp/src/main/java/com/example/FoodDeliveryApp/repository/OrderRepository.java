package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Order.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails,Integer> {

    @Query("SELECT o FROM OrderDetails o WHERE o.userId = ?1")
    //In place of ?1 we can write :userId
   public  List<OrderDetails> findAllOrdersByUserId(int userId);
    @Query("SELECT o FROM OrderDetails o WHERE o.restaurantId = ?1")
   public  List<OrderDetails> findAllOrderByRestaurantId(int restaurantId);
    @Query("SELECT o FROM OrderDetails o WHERE o.riderId = ?1")
    List<OrderDetails> findAllOrderByRiderId(int riderId);
    //Alternate for the above method
    List<OrderDetails> findByRiderId(int riderId);



}
