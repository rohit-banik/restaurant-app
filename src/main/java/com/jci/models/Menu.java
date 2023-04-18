package com.jci.models;

public class Menu {
    // Variables
    private int menuId;
    private String menuName;
    private String menuDesc;
    private String menuImage;

    //default constructor
    public Menu() {
    }
    //parameterised constructor
    public Menu(int menuId, String menuName, String menuDesc, String menuImage) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.menuImage = menuImage;
    }

    // getter and setter methods
    public int getMenuId() {    //getter method for menuID
        return menuId;
    }

    public void setMenuId(int menuId) { //setter method for menuId
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

    public String displayMenu() {   //method to display all the menu contents
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuDesc='" + menuDesc + '\'' +
                ", menuImage='" + menuImage + '\'' +
                '}';
    }
}
