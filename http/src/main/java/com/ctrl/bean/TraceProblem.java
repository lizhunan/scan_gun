package com.ctrl.bean;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

/**
 * Created by lizhunan on 2020/3/16
 */
@Entity
public class TraceProblem {

    @PrimaryKey(autoGenerate = true)
    private long index;
    private String id;
    private String time;
    @Ignore
    private String dangerContent;
    @Ignore
    private String creationTime;
    @Ignore
    private List<SysPicList> sysPicList;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDangerContent() {
        return dangerContent;
    }

    public void setDangerContent(String dangerContent) {
        this.dangerContent = dangerContent;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public List<SysPicList> getSysPicList() {
        return sysPicList;
    }

    public void setSysPicList(List<SysPicList> sysPicList) {
        this.sysPicList = sysPicList;
    }

    public class SysPicList{
        private String picUrl;
        private String moduleType;

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getModuleType() {
            return moduleType;
        }

        public void setModuleType(String moduleType) {
            this.moduleType = moduleType;
        }
    }
}
