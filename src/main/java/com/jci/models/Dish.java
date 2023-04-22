package com.jci.models;

public class Dish {
    // variable declaration
    private String dishId;
    private String dishName;
    private String dishDesc;
    private double dishPrice;
    private String dishImage;
    private String dishNature;
    private String categoryId;
    private String menuId;
    private boolean isDeleted = false;

    // default constructor
    public Dish() {
    }

    //parameterised constructor
    public Dish(String dishId, String dishName, String dishDesc, double dishPrice, String dishImage, String dishNature, String categoryId, String menuId, boolean isDeleted) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishDesc = dishDesc;
        this.dishPrice = dishPrice;
        this.dishImage = dishImage;
        this.dishNature = dishNature;
        this.categoryId = categoryId;
        this.menuId = menuId;
        this.isDeleted = isDeleted;
    }

    public String getDishId() {    //getter method for dishId
        return dishId;
    }

    public void setDishId(String dishId) { //setter method for dishId
        this.dishId = dishId;
    }

    public String getDishName() {   //getter method for dishName
        return dishName;
    }

    public void setDishName(String dishName) {  //setter method for dishName
        this.dishName = dishName;
    }

    public String getDishDesc() {   //getter method for dishDesc
        return dishDesc;
    }

    public void setDishDesc(String dishDesc) {  //setter method for dishDesc
        this.dishDesc = dishDesc;
    }

    public double getDishPrice() {  //getter method for dishPrice
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {    //setter method for dishPrice
        this.dishPrice = dishPrice;
    }

    public String getDishImage() {  //getter method for dishImage
        return dishImage;
    }

    public void setDishImage(String dishImage) {    //setter method for dishImage
        this.dishImage = dishImage;
    }

    public String getDishNature() { //getter method for dishNature
        return dishNature;
    }

    public void setDishNature(String dishNature) {  //setter method for dishNature
        this.dishNature = dishNature;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getMenuId() { return menuId; }

    public void setMenuId(String menuId) { this.menuId = menuId; }

    public boolean getIsDeleted() { return isDeleted; }

    public void setIsDeleted(boolean isDeleted) { this.isDeleted = isDeleted; }

}
