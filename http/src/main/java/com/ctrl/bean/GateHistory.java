package com.ctrl.bean;

/**
 * Created by lizhunan on 2020/7/2
 *
 * @author lizhunan
 */
public class GateHistory {

    private String gateName;
    private String alterBefore;
    private String alterAfter;
    private String alterTime;

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }

    public String getAlterBefore() {
        return alterBefore;
    }

    public void setAlterBefore(String alterBefore) {
        this.alterBefore = alterBefore;
    }

    public String getAlterAfter() {
        return alterAfter;
    }

    public void setAlterAfter(String alterAfter) {
        this.alterAfter = alterAfter;
    }

    public String getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(String alterTime) {
        this.alterTime = alterTime;
    }
}
