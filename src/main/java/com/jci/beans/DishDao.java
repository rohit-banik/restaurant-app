package com.jci.beans;

import com.jci.models.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


import java.sql.ResultSet;
import java.util.*;

@Repository
public class DishDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Dish> dishes = new ArrayList<Dish>(
//            Arrays.asList(
//                    new Dish(101, "Biryani", "Very Tasty Biryani Boss" , 280, "https://uploads-ssl.webflow.com/5c481361c604e53624138c2f/5dcbca1717dc0960f009aadb_biryani.jpg", "non-veg", 2),
//                    new Dish(102, "Veg Fried Rice", "Very Tasty Fried Rice Boss" , 130, "https://www.ticklingpalates.com/wp-content/uploads/2020/05/fried-rice-using-veggies.jpg", "veg", 3),
//                    new Dish(103, "Chicken Fried Rice", "Very Tasty Chicken Fried Rice Boss" , 150, "https://static.toiimg.com/thumb/75581339.cms?imgsize=1753029&width=800&height=800", "non-veg", 1),
//                    new Dish(104, "Vegan Salad", "Very Nasty Salad Boss" , 500, "https://images.immediate.co.uk/production/volatile/sites/30/2018/06/Vegan-salad-bowl-499145d.jpg?quality=90&resize=556,505", "vegan", 3),
//                    new Dish(105, "Ice cream", "Very Tasty Ice cream Boss" , 80, "https://veenaazmanov.com/wp-content/uploads/2017/07/Homemade-Chocolate-Ice-Cream-3.jpg", "veg", 3)
//            )
    );

    public DishDao() {
    }

    public List<Dish> getAllDishes() {
        String sql = "select * from dish";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Dish>(Dish.class));
    }
//    public List<Dish> getAllDishes(){
//        return dishes;
//    }

    public Dish getDishById(@PathVariable int id) {
        Dish fetchedDish = null;
        for(Dish dish:dishes) {
            if (dish.getDishId() == id) {
                fetchedDish = dish;
                break;
            }
        }
        return fetchedDish;
    }

    public Dish getDishByCategory(@PathVariable int id) {
        ArrayList<Integer> categoryDish = new ArrayList<Integer>();
        for(Dish dish:dishes) {
            if (dish.getCategoryId() == id) {
                categoryDish.add(id);
            }
        }
        return (Dish) dishes;
    }

    public Dish addDish(Dish dish) {
        dishes.add(dish);
        return dish;
    }

    public void deleteDishById(int id) {
        Iterator<Dish> it = dishes.iterator();
        while(it.hasNext()) {
            if(it.next().getDishId() == id) {
                it.remove();
                System.out.println("Dish Deleted");
            }
        }
    }

    public void updateDishById(int id, Dish dish) {
        for (Dish dishes : dishes) {
            if (dishes.getDishId() == id) {
                dishes.setDishName(dish.getDishName());
                dishes.setDishDesc(dish.getDishDesc());
                dishes.setDishPrice(dish.getDishPrice());
                dishes.setDishImage(dish.getDishImage());
                dishes.setDishNature(dish.getDishNature());
            }
        }
    }
}
