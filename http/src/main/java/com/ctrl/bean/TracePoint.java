package com.ctrl.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by lizhunan on 2020/3/5
 */
@Entity
public class TracePoint{

    @PrimaryKey(autoGenerate = true)
    private long id;
    private double latitude;
    private double longitude;
    private String createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
