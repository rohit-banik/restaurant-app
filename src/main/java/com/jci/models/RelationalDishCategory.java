package com.jci.models;

public class RelationalDishCategory {
    // variable declaration
    private String dishId;
    private String dishName;
    private String dishDesc;
    private double dishPrice;
    private String dishImage;
    private String dishNature;
    private boolean isDeleted;
    private String categoryId;
    private String categoryName;
    private String categoryDesc;
    private String categoryImage;
    private String menuId;
    private String menuName;
    private String menuDesc;
    private String menuImage;

    // Constructor
    public RelationalDishCategory() {
    }

    public RelationalDishCategory(String dishId, String dishName, String dishDesc, double dishPrice, String dishImage, String dishNature, String categoryId, boolean isDeleted, String categoryName, String categoryDesc, String categoryImage, String menuId, String menuName, String menuDesc, String menuImage) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishDesc = dishDesc;
        this.dishPrice = dishPrice;
        this.dishImage = dishImage;
        this.dishNature = dishNature;
        this.isDeleted = isDeleted;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.categoryImage = categoryImage;
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.menuImage = menuImage;
    }

    // Getter & Setter
    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDesc() {
        return dishDesc;
    }

    public void setDishDesc(String dishDesc) {
        this.dishDesc = dishDesc;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }

    public String getDishNature() {
        return dishNature;
    }

    public void setDishNature(String dishNature) {
        this.dishNature = dishNature;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }
}
