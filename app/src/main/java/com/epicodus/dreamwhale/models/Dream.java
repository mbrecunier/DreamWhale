package com.epicodus.dreamwhale.models;

public class Dream {
    private String date;
    private String color;
    private String description;
    private String pushID;

    public Dream() {}

    public Dream(String date, String color, String description) {
        this.date = date;
        this.color = color;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getPushID() {
        return pushID;
    }

    public void setPushID(String pushID) {
        this.pushID = pushID;
    }

}
