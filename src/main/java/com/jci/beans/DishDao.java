package com.jci.beans;

import com.jci.models.Dish;
import com.jci.models.RelationalDishCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DishDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
//    List<Dish> dishes = new ArrayList<Dish>();

    public DishDao() {
    }


    public List<Dish> getAllDishes() {
        List<Dish> relationalDishCategories = null;
        try {

//            String selectSql = "select d.*, c.*, m.* from dish d, category c, menu m where d.categoryId=c.categoryId and d.menuId=m.menuId and d.isDeleted = false";
            String selectSql = "select d.* from dish d where d.isDeleted = false";
            relationalDishCategories = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<Dish>(Dish.class));
        } catch (DataAccessException exp) {
            System.out.println("Error: " + exp.getMessage());
        }
        return relationalDishCategories;
    }

    public RelationalDishCategory getDishById(int id) {
        RelationalDishCategory category = null;
        try {

            String selectSqlbyId = "select d.*, c.*, m.* from dish d, category c, menu m where d.categoryId=c.categoryId and d.menuId=m.menuId and d.dishId = ? and d.isDeleted = false";
//            String selectSqlbyId = "select d.*, c.*, m.* from dish d, category c, menu m where d.categoryId=c.categoryId and d.menuId=m.menuId and d.dishId = ? and d.isDeleted = false";
            category = jdbcTemplate.queryForObject(selectSqlbyId, new BeanPropertyRowMapper<>(RelationalDishCategory.class), id);
        } catch (DataAccessException exp) {
            System.out.println("Error: " + exp.getMessage());
        }
        return category;

    }

    public List<RelationalDishCategory> getDishByCategory(int id) {
        List<RelationalDishCategory> relationalDishCategories = null;
        try {

            String selectSqlbyCategory = "select d.*, c.*, m.* from dish d, category c, menu m where d.categoryId=c.categoryId and d.menuId=m.menuId and d.categoryId = ? and d.isDeleted = false";
            relationalDishCategories = jdbcTemplate.query(selectSqlbyCategory, new BeanPropertyRowMapper<RelationalDishCategory>(RelationalDishCategory.class), id);
        } catch (DataAccessException exp) {
            System.out.println("Error: " + exp.getMessage());
        }
        return relationalDishCategories;

//        ArrayList<Integer> categoryDish = new ArrayList<Integer>();
//        for(Dish dish:dishes) {
//            if (dish.getCategoryId() == id) {
//                categoryDish.add(id);
//            }
//        }
//        return (Dish) dishes;
    }

    public String[] addDish(Dish dish) {
        String[] resp = new String[2];
        try {
            String insertSql = "insert into dish (dishId, dishName, dishDesc, dishPrice, dishImage, dishNature, categoryId, menuId isDeleted) values(?, ?, ? , ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(insertSql, dish.getDishId(), dish.getDishName(), dish.getDishDesc(), dish.getDishPrice(), dish.getDishImage(), dish.getDishNature(), dish.getCategoryId(), dish.getMenuId(), dish.getIsDeleted());
            resp[0] = "msg";
            resp[1] = "Dish added!";
        } catch (DataAccessException exp) {
            System.out.println("Error: " + exp.getMessage());
            resp[0] = "err";
            resp[1] = exp.getMessage();
        }
        return resp;
    }

    public String[] deleteDishById(int id) {
        String[] resp = new String[2];
        try {

            String softDeleteSql = "update dish set isDeleted = true where dishId = ?";
            jdbcTemplate.update(softDeleteSql, id);
            resp[0] = "msg";
            resp[1] = "Dish deleted";
        }catch (DataAccessException exp){
            System.out.println("Error: "+exp.getMessage());
            resp[0] = "err";
            resp[1] = exp.getMessage();
        }
        return resp;
    }

    public String[] updateDishById(int id, Dish dish) {
        String[] resp = new String[2];
        try {
            String updateSql = "update dish set dishName = ?, dishDesc = ?, dishPrice = ?, dishImage = ?, dishNature = ?, categoryId = ? where dishId = ?";
            jdbcTemplate.update(updateSql, dish.getDishName(), dish.getDishDesc(), dish.getDishPrice(), dish.getDishImage(),dish.getDishNature(), dish.getCategoryId(), id);
            resp[0] = "msg";
            resp[1] = "Dish with id "+ id + " updated!";
        }catch (DataAccessException exp){
            System.out.println("Error: "+exp.getMessage());
            resp[0] = "err";
            resp[1] = exp.getMessage();
        }
        return resp;
    }
}
