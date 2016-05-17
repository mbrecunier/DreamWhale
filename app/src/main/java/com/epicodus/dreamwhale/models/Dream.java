package com.epicodus.dreamwhale.models;

import org.parceler.Parcel;

import java.text.SimpleDateFormat;

@Parcel
public class Dream {
    private Long date;
    private String color;
    private String description;
    private boolean isPublic;

    public Dream() {}

    public Dream(Long date, String color, String description, boolean isPublic) {
        this.date = date;
        this.color = color;
        this.description = description;
        this.isPublic = isPublic;

    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean getPublic() {
        return isPublic;
    }

    public Long getDate() { return date; }

}
