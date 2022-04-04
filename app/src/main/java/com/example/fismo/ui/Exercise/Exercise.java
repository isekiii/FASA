package com.example.fismo.ui.Exercise;

public class Exercise {

    int imgID;
    int level;
    String description;
    String name;

    public Exercise (String name, String description, int level, int imgID){
        this.name = name;
        this.description = description;
        this.level = level;
        this.imgID = imgID;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
