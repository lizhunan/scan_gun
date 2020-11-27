package com.ctrl.bean;

import java.io.Serializable;

/**
 * Created by lizhunan on 2020/2/29
 */
public class Device implements Serializable {
    private String name;
    private String rtu;

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
}
