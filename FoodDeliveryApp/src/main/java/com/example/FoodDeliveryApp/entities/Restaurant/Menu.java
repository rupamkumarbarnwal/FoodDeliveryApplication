package com.example.FoodDeliveryApp.entities.Restaurant;

import com.example.FoodDeliveryApp.entities.Enum.MenuCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.Message;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int menuId;
    //@NotEmpty means the field must be neither blank nor null and atleast contain one item
    // @Not null means there  must be something inside the field does not matter whether it is meaningful or not
    // @Not blank means there must be something inside the filled and it must be meaningful
    @ManyToOne
    @JoinColumn(name="restaurantId", referencedColumnName = "restaurantId")
    private Restaurant restaurant;

    @NotEmpty(message = "Atleast order one item")
    private String itemName;
    private String description;

    @NotNull(message ="Price cannot be empty")
    private double price;




    private MenuCategory menuCategory;

    public Menu() {
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
    }
}
