package com.jci.models;

public class Menu {
    // Variables
    private String menuId;
    private String menuName;
    private String menuDesc;
    private String menuImage;

    //default constructor
    public Menu() {
    }
    //parameterised constructor
    public Menu(String menuId, String menuName, String menuDesc, String menuImage) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.menuImage = menuImage;
    }

    // getter and setter methods
    public String getMenuId() {    //getter method for menuID
        return menuId;
    }

    public void setMenuId(String menuId) { //setter method for menuId
        this.menuId = menuId;
    }

    public String getMenuName() {   //getter method for menuName
        return menuName;
    }

    public void setMenuName(String menuName) {  //setter method for menuName
        this.menuName = menuName;
    }

    public String getMenuDesc() {   //getter method for menuDesc
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {  //setter method for menuDesc
        this.menuDesc = menuDesc;
    }

    public String getMenuImage() {  //getter method for menuImage
        return menuImage;
    }

    public void setMenuImage(String menuImage) {    //setter method for menuImage
        this.menuImage = menuImage;
    }

}
