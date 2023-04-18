package com.jci.models;

public class Category {
//    variable declaration
    private int categoryID;
    private String categoryName;
    private String categoryDesc;
    private String categoryImage;

//    default constructor
    public Category() {
    }
//    parameterised constructor
    public Category(int categoryID, String categoryName, String categoryDesc, String categoryImage) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.categoryImage = categoryImage;
    }
    // getter and setter methods

    public int getCategoryID() { //getter method for categoryId
        return categoryID;
    }

    public void setCategoryID(int categoryID) { //setter method for categoryId
        this.categoryID = categoryID;
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

    public String getCategory() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDesc='" + categoryDesc + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
                '}';
    }
}
