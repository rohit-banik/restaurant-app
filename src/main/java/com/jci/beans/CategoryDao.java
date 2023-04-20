package com.jci.beans;

import com.jci.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Category> categories = new ArrayList<Category>();

    public CategoryDao() {
        String createTableSql = "CREATE TABLE category(categoryId int primary key, categoryName varchar(255), categoryDesc varchar(1000), categoryImage varchar(255), menuId int)";
    }

    public List<Category> getAllCategory(){
        List<Category> allCategories = null;
        String query = "select * from category";
        try{

            allCategories = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Category.class));
        }
        catch (DataAccessException exp){
            System.out.println(exp.getMessage());
        }
        return allCategories;
    }

    public Category getCategoryById(@PathVariable int id) {
        Category category = null;
        String query = "select * from category where categoryId = ?";
        try {
            category = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Category>(Category.class), id);
        }catch (DataAccessException exp){
            System.out.println("Error: " + exp.getMessage());
        }
        return category;
    }

    public String[] addCategory(Category category) {
        String[] resp = new String[2];
        try {
        String query = "insert into category (categoryId, categoryName, categoryDesc, categoryImage) values(?, ?, ? , ?)";
        jdbcTemplate.update(query, category.getCategoryId(), category.getCategoryName(), category.getCategoryDesc(), category.getCategoryImage());
            resp[0] = "msg";
            resp[1] = "Successfully created category.";
        }
        catch (DataAccessException exp){
            resp[0] = "err";
            resp[1] = "Failed to add category.";
        }
        return resp;

    }
}
