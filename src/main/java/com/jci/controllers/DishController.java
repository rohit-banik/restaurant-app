package com.jci.controllers;

import com.jci.beans.DishDao;
import com.jci.models.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {
    @Autowired
    DishDao dao;

    @GetMapping("/menuitems")
    public List<Dish> getAllDishes() { return dao.getAllDishes(); }

    @GetMapping("/menuitems/{id}")
    public Dish getDish(@PathVariable int id) { return dao.getDishById(id); }

    @PostMapping("/menuitem")
    public void createDish(@RequestBody Dish dish) {
        dao.addDish(dish);
    }

    @DeleteMapping("/menuitems/delete/{id}")
    public void deleteDish(@PathVariable("id") int id) { dao.deleteDishById(id); }

    @PutMapping("/menuitems/update/{id}")
    public void updateDish(@PathVariable int id, @RequestBody Dish dish) { dao.updateDishById(id, dish);}
}
