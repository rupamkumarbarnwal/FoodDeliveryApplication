package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.InvalidDataException;
import com.example.FoodDeliveryApp.entities.Enum.MenuCategory;
import com.example.FoodDeliveryApp.entities.Restaurant.Menu;
import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.repository.MenuRepository;
import com.example.FoodDeliveryApp.repository.RestaurantRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MenuService {
    @Autowired
    MenuRepository repository ;
    @Autowired
    RestaurantRepository restaurantRepository;
    public Menu  createMenu(Menu menu){
        repository.save(menu);
        return menu;
    }
    public Menu getMenu(int restaurantId){
        return (Menu) repository.findById(restaurantId).orElseThrow(()-> new InvalidDataException("No menu exist"));
    }
    public Menu updateMenu(Menu menu){
        Menu  old_menu = getMenu(menu.getMenuId());
        if(menu.getRestaurant().getRestaurantId()==0|| menu.getItemName()==null || menu.getPrice()==0) {
            throw new InvalidDataException("Restaurant id or itemMName or price cannot be null");
        }
        old_menu.setRestaurant(menu.getRestaurant());
        old_menu.setItemName(menu.getItemName());
        old_menu.setDescription(menu.getDescription());
        old_menu.setPrice(menu.getPrice());
        return old_menu;
    }
    public String deleteMenu(int menuId){
        repository.deleteById(menuId);
        return "Menu with given menu is deleted successfully";

    }
    public List<Menu> createMenusFromCSV(MultipartFile multipartFile) throws IOException
    {
        byte[] bytes = multipartFile.getBytes();
        File file = new File(UUID.randomUUID().toString());
        //Files.write(file.getPath(), bytes);
        FileOutputStream stream = new FileOutputStream(file.getPath());
        //InputStream stream = new ByteArrayInputStream(bytes);
        stream.write(bytes);
        FileReader fileReader = new FileReader(file.getPath());
        List<Menu> list = new ArrayList<Menu>();
        try(CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();){
            String[] row;
            int restaurantId;
            double price;
            String itemName, description;
            MenuCategory menuCategory;
            while((row = csvReader.readNext())!=null)
            {
                System.out.println("Inside the menu service createMenusFromCSV function"+row[0]);
                restaurantId=Integer.parseInt(row[0]);
                itemName=row[1];
                description=row[2];
                price=Double.parseDouble(row[3]);
                menuCategory = MenuCategory.getMenuCategory(row[4]);
                Menu menu = new Menu();
                menu.setDescription(description);
                menu.setItemName(itemName);
                menu.setPrice(price);
                menu.setMenuCategory(menuCategory);
                menu.setRestaurant(restaurantRepository.findById(restaurantId).get());
                list.add(menu);
            }


        }
        repository.saveAll(list);

        return list;
    }

}
