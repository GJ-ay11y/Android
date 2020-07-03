package com.gj.domain;

public class Menu_list {
    private int fid;
    private int sortid;
    private String fname;
    private String fimg;
    private String fintroduce;

    @Override
    public String toString() {
        return "Menu_list{" +
                "fid=" + fid +
                ", sortid=" + sortid +
                ", fname='" + fname + '\'' +
                ", fimg='" + fimg + '\'' +
                ", fintroduce='" + fintroduce + '\'' +
                '}';
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getSortid() {
        return sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFimg() {
        return fimg;
    }

    public void setFimg(String fimg) {
        this.fimg = fimg;
    }

    public String getFintroduce() {
        return fintroduce;
    }

    public void setFintroduce(String fintroduce) {
        this.fintroduce = fintroduce;
    }
}
