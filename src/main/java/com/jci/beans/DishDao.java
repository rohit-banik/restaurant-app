package com.jci.beans;

import com.jci.models.Dish;
import com.jci.models.RelationalDishCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.*;


@Repository
public class DishDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Dish> dishes = new ArrayList<Dish>();

    public DishDao() {
    }


    public List<RelationalDishCategory> getAllDishes() {
        String selectSql = "select d.*, c.*, m.* from dish d, category c, menu m where d.categoryId=c.categoryId and d.menuId=m.menuId and d.isDeleted = 0";
        return jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<RelationalDishCategory>(RelationalDishCategory.class));
    }

    public RelationalDishCategory getDishById(@PathVariable int id) {
        String selectSqlbyId = "select d.*, c.*, m.* from dish d, category c, menu m where d.categoryId=c.categoryId and d.menuId=m.menuId and d.dishId = ? and d.isDeleted = 0";
        return jdbcTemplate.queryForObject(selectSqlbyId, new Object[]{id}, new BeanPropertyRowMapper<RelationalDishCategory>(RelationalDishCategory.class));
    }

    public List<RelationalDishCategory> getDishByCategory(@PathVariable int id) {
        String selectSqlbyCategory = "select d.*, c.*, m.* from dish d, category c, menu m where d.categoryId=c.categoryId and d.menuId=m.menuId and d.categoryId = ? and d.isDeleted = 0";
        return jdbcTemplate.query(selectSqlbyCategory, new Object[]{id}, new BeanPropertyRowMapper<RelationalDishCategory>(RelationalDishCategory.class));
        //        ArrayList<Integer> categoryDish = new ArrayList<Integer>();
//        for(Dish dish:dishes) {
//            if (dish.getCategoryId() == id) {
//                categoryDish.add(id);
//            }
//        }
//        return (Dish) dishes;
    }

    public void addDish(Dish dish) {
        String insertSql = "insert into dish (dishId, dishName, dishDesc, dishPrice, dishImage, dishNature, categoryId, menuId) values(?, ?, ? , ?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertSql, dish.getDishId(), dish.getDishName(), dish.getDishDesc(), dish.getDishPrice(), dish.getDishImage(), dish.getDishNature(), dish.getCategoryId(), dish.getMenuId());
        System.out.println("Dish inserted");
    }

    public void deleteDishById(int id) {
        String softDeleteSql = "update dish set isDeleted = 1 where dishId = ?";
        jdbcTemplate.update(softDeleteSql, id);
    }
    public void updateDishById(int id, Dish dish) {
        String updateSql = "update dish set dishName = ?, dishDesc = ?, dishPrice = ?, dishImage = ?, dishNature = ?, categoryId = ? where dishId = ?";
        jdbcTemplate.update(updateSql, dish.getDishName(), dish.getDishDesc(), dish.getDishPrice(), dish.getDishNature(), dish.getCategoryId());
    }
}
