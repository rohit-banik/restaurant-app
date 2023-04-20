package com.jci.controllers;

import com.google.gson.Gson;
import com.jci.beans.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class MenuController {
    @Autowired
    MenuDao dao;

    @GetMapping("/menu")
    public String getMenu() { return new Gson().toJson(dao.getAllMenu()); }

    @GetMapping("/menu/{id}")
    public String getMenuById(@PathVariable int id) { return new Gson().toJson(dao.getMenuById(id)); }

}
