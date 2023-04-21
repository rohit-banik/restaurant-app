package com.jci.beans;

import com.jci.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Menu> categories = new ArrayList<Menu>();

    public MenuDao() {
        String createTableSql = "CREATE TABLE menu(menuId int primary key, menuName varchar(255), menuDesc varchar(1000), menuImage varchar(255))";
    }

    public List<Menu> getAllMenu() {
        List<Menu> menus = null;
        try {

            String selectSqlbyId = "select * from menu";
            menus =  jdbcTemplate.query(selectSqlbyId, new BeanPropertyRowMapper<Menu>(Menu.class));
        } catch (DataAccessException exp) {
            System.out.println("Error: "+exp.getMessage());
        }
        return menus;
    }

    public Menu getMenuById(@PathVariable int id) {
        String selectSqlbyId = "select * from menu where menuId = ?";
        return jdbcTemplate.queryForObject(selectSqlbyId, new Object[]{id}, new BeanPropertyRowMapper<Menu>(Menu.class));
    }

}
