package com.gj.domain;

public class UserClock {
    private int dakaid;
    private String uname;
    private String time;
    private String meal;
    private String foodname;
    private String addimg;

    @Override
    public String toString() {
        return "UserClock{" +
                "dakaid=" + dakaid +
                ", uname='" + uname + '\'' +
                ", time='" + time + '\'' +
                ", meal='" + meal + '\'' +
                ", foodname='" + foodname + '\'' +
                ", addimg='" + addimg + '\'' +
                '}';
    }

    public int getDakaid() {
        return dakaid;
    }

    public void setDakaid(int dakaid) {
        this.dakaid = dakaid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
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
}
