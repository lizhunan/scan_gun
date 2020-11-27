package com.ctrl.bean;

import java.util.List;

public class Contact {

    private String deptName;
    private String deptId;
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

    public static class Datas{
        private String name;
        private String telephone;
        private String eMail;
        private String zhiwu;
        private String danwei;
        private String sex;
        private String gong_hao;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String geteMail() {
            return eMail;
        }

        public void seteMail(String eMail) {
            this.eMail = eMail;
        }

        public String getZhiwu() {
            return zhiwu;
        }

        public void setZhiwu(String zhiwu) {
            this.zhiwu = zhiwu;
        }

        public String getDanwei() {
            return danwei;
        }

        public void setDanwei(String danwei) {
            this.danwei = danwei;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getGong_hao() {
            return gong_hao;
        }

        public void setGong_hao(String gong_hao) {
            this.gong_hao = gong_hao;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
