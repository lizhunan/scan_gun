package com.ctrl.bean;

import com.ctrl.bean.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhunan on 2020/2/26
 */
public class Site extends BaseBean implements Serializable {

    private String deptId;
    private String deptName;
    private List<Datas> datas;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<Datas> getDatas() {
        return datas;
    }

    public void setDatas(List<Datas> datas) {
        this.datas = datas;
    }

    public class Datas implements Serializable {
        private String guanlisuoName;
        private String stcd;
        private String tm;
        private String leijiLl;
        private String shunshiLl;
        private String stnm;
        private String channelName;
        private String strTm;
        private String wz;
        private String gateName;
        private String rtu;
        private String gateOpening;
        private String openState;
        private String gateCondition;
        private String temperature;
        private String humidity;
        private String pressure;
        private String soilTemperature;
        private String radiation;
        private String windDirection;
        private String windSpeed;
        private String rainfall;

        public String getGuanlisuoName() {
            return guanlisuoName;
        }

        public void setGuanlisuoName(String guanlisuoName) {
            this.guanlisuoName = guanlisuoName;
        }

        public String getStnm() {
            return stnm;
        }

        public void setStnm(String stnm) {
            this.stnm = stnm;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getStrTm() {
            return strTm;
        }

        public void setStrTm(String strTm) {
            this.strTm = strTm;
        }

        public String getWz() {
            return wz;
        }

        public void setWz(String wz) {
            this.wz = wz;
        }

        public String getStcd() {
            return stcd;
        }

        public void setStcd(String stcd) {
            this.stcd = stcd;
        }

        public String getTm() {
            return tm;
        }

        public void setTm(String tm) {
            this.tm = tm;
        }

        public String getLeijiLl() {
            return leijiLl;
        }

        public void setLeijiLl(String leijiLl) {
            this.leijiLl = leijiLl;
        }

        public String getShunshiLl() {
            return shunshiLl;
        }

        public void setShunshiLl(String shunshiLl) {
            this.shunshiLl = shunshiLl;
        }

        public String getGateName() {
            return gateName;
        }

        public void setGateName(String gateName) {
            this.gateName = gateName;
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

        public String getOpenState() {
            return openState;
        }

        public void setOpenState(String openState) {
            this.openState = openState;
        }

        public String getGateCondition() {
            return gateCondition;
        }

        public void setGateCondition(String gateCondition) {
            this.gateCondition = gateCondition;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getSoilTemperature() {
            return soilTemperature;
        }

        public void setSoilTemperature(String soilTemperature) {
            this.soilTemperature = soilTemperature;
        }

        public String getRadiation() {
            return radiation;
        }

        public void setRadiation(String radiation) {
            this.radiation = radiation;
        }

        public String getWindDirection() {
            return windDirection;
        }

        public void setWindDirection(String windDirection) {
            this.windDirection = windDirection;
        }

        public String getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public String getRainfall() {
            return rainfall;
        }

        public void setRainfall(String rainfall) {
            this.rainfall = rainfall;
        }
    }
}
