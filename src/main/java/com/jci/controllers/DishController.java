package com.jci.controllers;

import com.jci.beans.DishDao;
import com.jci.models.Dish;
import com.jci.models.RelationalDishCategory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
public class DishController {
    @Autowired
    DishDao dao;

    @GetMapping("/menuitems")
    public @ResponseBody Map<String, Object> getAllDishes() {
        List<Dish> dishes = dao.getAllDishes();
        JSONObject resp = new JSONObject();
        if(dishes != null){
            resp.put("msg", "Success");
            resp.put("dishes", dishes);
        }
        else{
            resp.put("err", "Couldn't fetch data");
        }
        return resp.toMap();
    }

    @GetMapping("/menuitems/{id}")
    public @ResponseBody Map<String, Object> getDish(@PathVariable String id) {
        Dish dish = dao.getDishById(id);
        JSONObject resp = new JSONObject();
        if(dish != null){
            resp.put("msg", "Success");
            resp.put("dish", dish);
        }
        else{
            resp.put("err", "Couldn't fetch data");
        }
        return resp.toMap();
    }

    @GetMapping("/menuitems/menu/{id}")
    public @ResponseBody Map<String, Object> getDishbyCategory(@PathVariable String id) {
        List<Dish> menuByCat = dao.getDishByMenuId(id);
        JSONObject resp = new JSONObject();
        if(menuByCat != null){
            resp.put("msg", "Success");
            resp.put("dishes", menuByCat);
        }
        else{
            resp.put("err", "Couldn't fetch data");
        }
        return resp.toMap();
    }

    @PostMapping("/menuitems")
    public @ResponseBody Map<String, Object> createDish(@RequestBody Dish dish) {
        dish.setDishId(UUID.randomUUID().toString());
        String[] resp = dao.addDish(dish);
        return new JSONObject().put(resp[0], resp[1]).toMap();
    }

    @DeleteMapping("/menuitems/delete/{id}")
    public @ResponseBody Map<String, Object> deleteDish(@PathVariable String id) {
        String[] resp = dao.deleteDishById(id);
        return new JSONObject().put(resp[0], resp[1]).toMap();

    }

    @PutMapping("/menuitems/update/{id}")
    public @ResponseBody Map<String, Object> updateDish(@PathVariable String id, @RequestBody Dish dish) {
        String[] resp = dao.updateDishById(id, dish);
        return new JSONObject().put(resp[0], resp[1]).toMap();
    }
}
