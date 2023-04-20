package com.jci.controllers;

import com.google.gson.Gson;
import com.jci.beans.DishDao;
import com.jci.models.Dish;
import com.jci.models.RelationalDishCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DishController {
    @Autowired
    DishDao dao;

    @GetMapping("/menuitems")
    public String getAllDishes() {
        return new Gson().toJson(dao.getAllDishes());
    }

    @GetMapping("/menuitems/{id}")
    public String getDish(@PathVariable int id) { return new Gson().toJson(dao.getDishById(id)); }

    @GetMapping("/menuitems/category/{id}")
    public String getDishbyCategory(@PathVariable int id) { return new Gson().toJson(dao.getDishByCategory(id)); }

    @PostMapping("/menuitem")
    public void createDish(@RequestBody Dish dish) {
        dao.addDish(dish);
    }

    @DeleteMapping("/menuitems/delete/{id}")
    public void deleteDish(@PathVariable("id") int id) { dao.deleteDishById(id); }

    @PutMapping("/menuitems/update/{id}")
    public void updateDish(@PathVariable int id, @RequestBody Dish dish) { dao.updateDishById(id, dish);}
}
