package com.jci.controllers;

import com.jci.beans.MenuDao;
import com.jci.models.Menu;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
public class MenuController {
    @Autowired
    MenuDao dao;

    @GetMapping("/menus")

    public @ResponseBody Map<String, Object> getMenu() {
        List<Menu> menus = dao.getAllMenu();
        JSONObject resp = new JSONObject();
        if(menus != null){
            resp.put("msg", "Success");
            resp.put("menus", menus);
        }
        else{
            resp.put("err", "Couldn't fetch data");
        }
        return resp.toMap();
    }

    @GetMapping("/menus/{id}")
    public @ResponseBody Map<String, Object> getMenuById(@PathVariable int id) {
        Menu menu = dao.getMenuById(id);
        JSONObject resp = new JSONObject();
        if(menu != null){
            resp.put("msg", "Success");
            resp.put("menu", menu);
        }
        else{
            resp.put("err", "Couldn't fetch data");
        }
        return resp.toMap();
    }

}
