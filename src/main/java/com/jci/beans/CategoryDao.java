package com.jci.beans;

import com.jci.models.Category;
import com.jci.models.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Category> categories = new ArrayList<Category>(
//            Arrays.asList(
//                    new Category(1, "Veg", "Vegetables only", "https://uploads-ssl.webflow.com/5c481361c604e53624138c2f/5dcbca1717dc0960f009aadb_biryani.jpg"),
//                    new Category(2, "Nonveg", "Chicken and Fish only", "https://www.ticklingpalates.com/wp-content/uploads/2020/05/fried-rice-using-veggies.jpg"),
//                    new Category(3, "Starter", "Start like a king", "https://static.toiimg.com/thumb/75581339.cms?imgsize=1753029&width=800&height=800"),
//                    new Category(4, "Dessert", "A Sweet Ending", "https://images.immediate.co.uk/production/volatile/sites/30/2018/06/Vegan-salad-bowl-499145d.jpg?quality=90&resize=556,505")
//            )
    );

    public CategoryDao() {
        String createTableSql = "CREATE TABLE category(categoryId int primary key, categoryName varchar(255), categoryDesc varchar(1000), categoryImage varchar(255), menuId int)";
    }

//    public List<Category> getAllCategory(){ return categories; }

    public Category getCategoryById(@PathVariable int id) {
        String selectSqlbyId = "select * from category where dishId = ? and isDeleted = 0";
        return jdbcTemplate.queryForObject(selectSqlbyId, new Object[]{id}, new BeanPropertyRowMapper<Category>(Category.class));
//        Category fetchedCategory = null;
//        for(Category category:categories) {
//            if (category.getCategoryID() == id) {
//                fetchedCategory = category;
//                break;
//            }
//        }
//        return fetchedCategory;
    }

    public Category addCategory(Category category) {
        categories.add(category);
        return category;
    }
}
