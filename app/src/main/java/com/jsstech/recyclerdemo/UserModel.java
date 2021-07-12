package com.jsstech.recyclerdemo;

public class UserModel {
    private String dates;
    private String exp;

    public UserModel(String dates,String exp) {
        this.dates = dates;
        this.exp = exp;
    }

    public UserModel() {
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
