package com.gj.domain;

public class AddMenu {
    private int addid;
    private String uname;
    private String foodname;
    private String addimg;
    private String learn;
    private String mian;
    private String fuliao;
    private String buzhou;

    @Override
    public String toString() {
        return "AddMenu{" +
                "addid=" + addid +
                ", uname='" + uname + '\'' +
                ", foodname='" + foodname + '\'' +
                ", addimg='" + addimg + '\'' +
                ", learn='" + learn + '\'' +
                ", main='" + mian + '\'' +
                ", fuliao='" + fuliao + '\'' +
                ", buzhou='" + buzhou + '\'' +
                '}';
    }

    public int getAddid() {
        return addid;
    }

    public void setAddid(int addid) {
        this.addid = addid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getAddimg() {
        return addimg;
    }

    public void setAddimg(String addimg) {
        this.addimg = addimg;
    }

    public String getLearn() {
        return learn;
    }

    public void setLearn(String learn) {
        this.learn = learn;
    }

    public String getMian() {
        return mian;
    }

    public void setMian(String mian) {
        this.mian = mian;
    }

    public String getFuliao() {
        return fuliao;
    }

    public void setFuliao(String fuliao) {
        this.fuliao = fuliao;
    }

    public String getBuzhou() {
        return buzhou;
    }

    public void setBuzhou(String buzhou) {
        this.buzhou = buzhou;
    }
}
