package com.ctrl.bean;

/**
 * Created by lizhunan on 2020/3/6
 */
public class TraceTask {
    private String id;
    private String allKilo;//总公里数
    private String several;//巡检次数
    private String allTime;//总用时
    private String averKilo;//平均公里数
    private String ytime;//巡检年份
    private String mtime;//巡检月份
    private String dangerAll;//每月总条数
    private String jobAll;//每月总次数
    private String startTime;//巡检开始时间
    private String time;//巡检用时
    private String roadLong;//巡检用时
    private String week;//巡检星期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAllKilo() {
        return allKilo;
    }

    public void setAllKilo(String allKilo) {
        this.allKilo = allKilo;
    }

    public String getSeveral() {
        return several;
    }

    public void setSeveral(String several) {
        this.several = several;
    }

    public String getAllTime() {
        return allTime;
    }

    public void setAllTime(String allTime) {
        this.allTime = allTime;
    }

    public String getAverKilo() {
        return averKilo;
    }

    public void setAverKilo(String averKilo) {
        this.averKilo = averKilo;
    }

    public String getYtime() {
        return ytime;
    }

    public void setYtime(String ytime) {
        this.ytime = ytime;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getDangerAll() {
        return dangerAll;
    }

    public void setDangerAll(String dangerAll) {
        this.dangerAll = dangerAll;
    }

    public String getJobAll() {
        return jobAll;
    }

    public void setJobAll(String jobAll) {
        this.jobAll = jobAll;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
