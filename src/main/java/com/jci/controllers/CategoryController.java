package com.jci.controllers;

import com.jci.beans.CategoryDao;
import com.jci.models.Category;
import com.jci.models.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CategoryController {
    @Autowired
    CategoryDao dao;

    @GetMapping("/category")
    public List<Category> getCategory() { return dao.getAllCategory(); }

    @GetMapping("/menuitems/{id}")
    public Category getCategoryById(@PathVariable int id) { return dao.getCategoryById(id); }

    @PostMapping("/menuitem")
    public void createCategory(@RequestBody Category category) {
        dao.addCategory(category);
    }

}
