package com.ctrl.bean;

import java.util.List;

/**
 * Created by lizhunan on 2020/2/29
 */
public class DeviceDetail {
    private String name;
    private String rtu;
    private String type;
    private String manageName;
    private String model;
    private String factory;
    private String manufacturer;
    private String leader;
    private String tel;
    private String price;
    private List<Data> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRtu() {
        return rtu;
    }

    public void setRtu(String rtu) {
        this.rtu = rtu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public class Data{
        private String repairType;
        private String repairman;
        private String repairTime;
        private String repairResults;

        public String getRepairType() {
            return repairType;
        }

        public void setRepairType(String repairType) {
            this.repairType = repairType;
        }

        public String getRepairman() {
            return repairman;
        }

        public void setRepairman(String repairman) {
            this.repairman = repairman;
        }

        public String getRepairTime() {
            return repairTime;
        }

        public void setRepairTime(String repairTime) {
            this.repairTime = repairTime;
        }

        public String getRepairResults() {
            return repairResults;
        }

        public void setRepairResults(String repairResults) {
            this.repairResults = repairResults;
        }
    }
}
