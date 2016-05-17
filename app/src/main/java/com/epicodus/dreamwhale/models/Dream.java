package com.epicodus.dreamwhale.models;

import org.parceler.Parcel;

@Parcel
public class Dream {
    private String date;
    private String color;
    private String description;
    private String userID;
    private boolean isPublic;

    public Dream() {}

    public Dream(String date, String color, String description, boolean isPublic) {
        this.date = date;
        this.color = color;
        this.description = description;
        this.isPublic = isPublic;

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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean getPublic() {
        return isPublic;
    }

}
