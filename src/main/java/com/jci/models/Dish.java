package com.jci.models;

public class Dish {
    // variable declaration
    private int dishId;
    private String dishName;
    private String dishDesc;
    private double dishPrice;
    private String dishImage;
    private String dishNature;
    private int categoryId;

    // default constructor
    public Dish() {
    }

    //parameterised constructor
    public Dish(int dishId, String dishName, String dishDesc, double dishPrice, String dishImage, String dishNature, int categoryId) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishDesc = dishDesc;
        this.dishPrice = dishPrice;
        this.dishImage = dishImage;
        this.dishNature = dishNature;
        this.categoryId = categoryId;
    }

    public int getDishId() {    //getter method for dishId
        return dishId;
    }

    public void setDishId(int dishId) { //setter method for dishId
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String displayDish() {
        return "Dish{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishDesc='" + dishDesc + '\'' +
                ", dishPrice=" + dishPrice +
                ", dishImage='" + dishImage + '\'' +
                ", dishNature='" + dishNature + '\'' +
                '}';
    }
}
