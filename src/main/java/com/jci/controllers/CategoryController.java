package com.jci.controllers;

import com.google.gson.Gson;
import com.jci.beans.CategoryDao;
import com.jci.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CategoryController {
    @Autowired
    CategoryDao dao;

    @GetMapping("/category")
    public String getCategory() { return new Gson().toJson(dao.getAllCategory()); }

    @GetMapping("/category/{id}")
    public String getCategoryById(@PathVariable int id) { return new Gson().toJson(dao.getCategoryById(id)); }

    @PostMapping("/category")
    public void createCategory(@RequestBody Category category) {
        dao.addCategory(category);
    }

}
