package com.ctrl.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhunan on 2020/2/27
 */
public class Sluice extends BaseBean implements Serializable {
    private String id;
    private String gateName;
    private String waterUnitName;
    private String manageName;
    private String channelName;
    private String lgtd;
    private String lttd;

    private String gateOpeningMax;
    private String rtu;
    private String gateOpening;
    private String gateCondition;
    private String time;
    private String openState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }

    public String getWaterUnitName() {
        return waterUnitName;
    }

    public void setWaterUnitName(String waterUnitName) {
        this.waterUnitName = waterUnitName;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getGateOpeningMax() {
        return gateOpeningMax;
    }

    public void setGateOpeningMax(String gateOpeningMax) {
        this.gateOpeningMax = gateOpeningMax;
    }

    public String getRtu() {
        return rtu;
    }

    public void setRtu(String rtu) {
        this.rtu = rtu;
    }

    public String getGateOpening() {
        return gateOpening;
    }

    public void setGateOpening(String gateOpening) {
        this.gateOpening = gateOpening;
    }

    public String getGateCondition() {
        return gateCondition;
    }

    public void setGateCondition(String gateCondition) {
        this.gateCondition = gateCondition;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOpenState() {
        return openState;
    }

    public void setOpenState(String openState) {
        this.openState = openState;
    }

    public String getLgtd() {
        return lgtd;
    }

    public void setLgtd(String lgtd) {
        this.lgtd = lgtd;
    }

    public String getLttd() {
        return lttd;
    }

    public void setLttd(String lttd) {
        this.lttd = lttd;
    }
}
