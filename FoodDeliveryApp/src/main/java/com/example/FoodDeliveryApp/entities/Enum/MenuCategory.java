package com.example.FoodDeliveryApp.entities.Enum;

import com.example.FoodDeliveryApp.Exception.EnumOptionNotAvailableException;

public enum MenuCategory {
    SPICY, NON_SPICY, BENGALI, NORTH_INDIAN, SOUTH_INDIAN;
    public static MenuCategory getMenuCategory(String menuCategory) throws EnumOptionNotAvailableException
    //Can EnumConstantNotPresentException be thrown
    {
        switch(menuCategory)
        {
            case "SPICY": return SPICY;
            case "NON_SPICY": return NON_SPICY;
            case "BENAGLI" : return BENGALI;
            case "NORTH_INDIAN" : return NORTH_INDIAN;
            case "SOUTH_INDIAN" : return SOUTH_INDIAN;
            default: throw new EnumOptionNotAvailableException("No such menu Category Available");
        }
    }
}
