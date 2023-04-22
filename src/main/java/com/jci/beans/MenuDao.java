package com.jci.beans;

import com.jci.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Menu> categories = new ArrayList<Menu>();

    public MenuDao() {
    }

    @PostConstruct
    public void createTable() {
        String createTableSql = "CREATE TABLE if not exists menu (menuId varchar(4) primary key, menuName varchar(255), menuDesc varchar(1000), menuImage varchar(255))";
        int execQuery = jdbcTemplate.update(createTableSql);
        if (execQuery!=0)
            System.out.println("Menu table created");
        else
            System.out.println("Menu table already exists");
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
