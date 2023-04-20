package com.jci.models;

public class Category {
//    variable declaration
    private int categoryId;
    private String categoryName;
    private String categoryDesc;
    private String categoryImage;

//    default constructor
    public Category() {
    }
//    parameterised constructor
    public Category(int categoryId, String categoryName, String categoryDesc, String categoryImage) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.categoryImage = categoryImage;
    }
    // getter and setter methods

    public int getCategoryId() { //getter method for categoryId
        return categoryId;
    }

    public void setCategoryId(int categoryId) { //setter method for categoryId
        this.categoryId = categoryId;
    }

    public String getCategoryName() {   //getter method for categoryName
        return categoryName;
    }

    public void setCategoryName(String categoryName) {  //setter method for categoryName
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {   //getter method for categoryDesc
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) { //setter method for categoryDesc
        this.categoryDesc = categoryDesc;
    }

    public String getCategoryImage() {  //getter method for categoryImage
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {    //setter method for categoryImage
        this.categoryImage = categoryImage;
    }

}
