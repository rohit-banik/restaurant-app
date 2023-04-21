package com.jci.beans;

import com.jci.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
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
        String createTableSql = "CREATE TABLE category if not(categoryId int primary key, categoryName varchar(255), categoryDesc varchar(1000), categoryImage varchar(255), menuId int)";
        jdbcTemplate.update(createTableSql);
    }

    public List<Category> getAllCategory(){
        String selectSqlbyId = "select * from category";
        return jdbcTemplate.query(selectSqlbyId, new BeanPropertyRowMapper<Category>(Category.class));
    }

    public Category getCategoryById(@PathVariable int id) {
        String selectSqlbyId = "select * from category where categoryId = ?";
        return jdbcTemplate.queryForObject(selectSqlbyId, new Object[]{id}, new BeanPropertyRowMapper<Category>(Category.class));
    }

    public void addCategory(Category category) {
        String insertSql = "insert into category (categoryId, categoryName, categoryDesc, categoryImage) values(?, ?, ? , ?)";
        jdbcTemplate.update(insertSql, category.getCategoryId(), category.getCategoryName(), category.getCategoryDesc(), category.getCategoryImage());
        System.out.println("Category inserted");
    }
}
