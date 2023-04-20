package com.jci.controllers;

import com.jci.beans.CategoryDao;
import com.jci.models.Category;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {
    @Autowired
    CategoryDao dao;

    @GetMapping("/categories")
    public @ResponseBody Map<String, Object> getCategory() {
        List<Category> categories = dao.getAllCategory();
        JSONObject resp = new JSONObject();
        if(categories != null){
        resp.put("msg", "Success");
        resp.put("categories", categories);
        }
        else{
            resp.put("err", "Couldn't fetch data");
        }
        return resp.toMap();
    }

    @GetMapping("/categories/{id}")
    public @ResponseBody Map<String, Object> getCategoryById(@PathVariable int id) {
        Category ct = dao.getCategoryById(id);
        JSONObject resp = new JSONObject();
        if(ct != null){
            resp.put("msg", "Success");
            resp.put("category", ct);
        }
        else{
            resp.put("err", "Couldn't fetch data");
        }
        return resp.toMap();
    }

    @PostMapping("/categories")
    public @ResponseBody Map<String, Object> createCategory(@RequestBody Category category) {
        JSONObject msg = new JSONObject();
        String[] resp = dao.addCategory(category);
        msg.put(resp[0], resp[1]);
        return msg.toMap();
    }

}
