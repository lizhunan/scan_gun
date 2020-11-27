package com.ctrl.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhunan on 2020/3/3
 */
public class Problem extends BaseBean implements Serializable {

    private String id;
    private String dangerContent;
    private String deptName;
    private String settleBy;
    private String settleTime;
    private String settleContent;
    private String settleStatus;
    private String dangerTitle;
    private String dangerLongitude;
    private String dangerLatitude;
    private String createBy;
    private String dangerLocation;
    private String inLocation;
    private String creationTime;
    private List<SysPicList> sysPicList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDangerContent() {
        return dangerContent;
    }

    public void setDangerContent(String dangerContent) {
        this.dangerContent = dangerContent;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSettleBy() {
        return settleBy;
    }

    public void setSettleBy(String settleBy) {
        this.settleBy = settleBy;
    }

    public String getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(String settleTime) {
        this.settleTime = settleTime;
    }

    public String getSettleContent() {
        return settleContent;
    }

    public void setSettleContent(String settleContent) {
        this.settleContent = settleContent;
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    public List<SysPicList> getSysPicList() {
        return sysPicList;
    }

    public void setSysPicList(List<SysPicList> sysPicList) {
        this.sysPicList = sysPicList;
    }

    public String getDangerTitle() {
        return dangerTitle;
    }

    public void setDangerTitle(String dangerTitle) {
        this.dangerTitle = dangerTitle;
    }

    public String getDangerLongitude() {
        return dangerLongitude;
    }

    public void setDangerLongitude(String dangerLongitude) {
        this.dangerLongitude = dangerLongitude;
    }

    public String getDangerLatitude() {
        return dangerLatitude;
    }

    public void setDangerLatitude(String dangerLatitude) {
        this.dangerLatitude = dangerLatitude;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getDangerLocation() {
        return dangerLocation;
    }

    public void setDangerLocation(String dangerLocation) {
        this.dangerLocation = dangerLocation;
    }

    public String getInLocation() {
        return inLocation;
    }

    public void setInLocation(String inLocation) {
        this.inLocation = inLocation;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public class SysPicList{
        private String picUrl;
        private String createDate;
        private String moduleType;

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getModuleType() {
            return moduleType;
        }

        public void setModuleType(String moduleType) {
            this.moduleType = moduleType;
        }
    }
}
