package com.ctrl.bean;

import java.util.List;

/**
 * Created by lizhunan on 2020/3/14
 */
public class TraceHistory {

    private String userName;
    private String time;
    private String roadLong;
    private String several;
    private String startTime;
    private String endTime;
    private String detpName;
    private List<Datas> datas;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoadLong() {
        return roadLong;
    }

    public void setRoadLong(String roadLong) {
        this.roadLong = roadLong;
    }

    public String getSeveral() {
        return several;
    }

    public void setSeveral(String several) {
        this.several = several;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDetpName() {
        return detpName;
    }

    public void setDetpName(String detpName) {
        this.detpName = detpName;
    }

    public List<Datas> getDatas() {
        return datas;
    }

    public void setDatas(List<Datas> datas) {
        this.datas = datas;
    }

    public class Datas {
        private String longitude;
        private String latitude;

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
    }
}
