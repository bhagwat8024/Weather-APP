package com.nagarro.bhagwat.weatherapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WeatherInfo {
    @PrimaryKey(autoGenerate = true)
    private Long infoId;
    private String code;
    private String description;
    private String icon;

    public WeatherInfo() {
    }

    public WeatherInfo(Long infoId, String code, String description, String icon) {
        this.infoId = infoId;
        this.code = code;
        this.description = description;
        this.icon = icon;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
