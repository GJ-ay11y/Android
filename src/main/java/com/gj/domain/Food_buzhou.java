package com.gj.domain;

public class Food_buzhou {
    private int fimgid;
    private int sortid;
    private int fid;//菜品id
    private String fimgminute;//菜品图片
    private String foodbuzhou;//步骤
    private String fname;//菜品名称
    private String fintroduce;//菜品介绍
    private String main_ingredient;//菜品主料
    private String ingredient;//菜品辅料
    private  String fimg;//主图

    @Override
    public String toString() {
        return "Food_buzhou{" +
                "fimgid=" + fimgid +
                ", sortid=" + sortid +
                ", fid=" + fid +
                ", fimgminute='" + fimgminute + '\'' +
                ", foodbuzhou='" + foodbuzhou + '\'' +
                ", fname='" + fname + '\'' +
                ", fintroduce='" + fintroduce + '\'' +
                ", main_ingredient='" + main_ingredient + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", fimg='" + fimg + '\'' +
                '}';
    }

    public int getFimgid() {
        return fimgid;
    }

    public void setFimgid(int fimgid) {
        this.fimgid = fimgid;
    }

    public int getSortid() {
        return sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFimgminute() {
        return fimgminute;
    }

    public void setFimgminute(String fimgminute) {
        this.fimgminute = fimgminute;
    }

    public String getFoodbuzhou() {
        return foodbuzhou;
    }

    public void setFoodbuzhou(String foodbuzhou) {
        this.foodbuzhou = foodbuzhou;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFintroduce() {
        return fintroduce;
    }

    public void setFintroduce(String fintroduce) {
        this.fintroduce = fintroduce;
    }

    public String getMain_ingredient() {
        return main_ingredient;
    }

    public void setMain_ingredient(String main_ingredient) {
        this.main_ingredient = main_ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getFimg() {
        return fimg;
    }

    public void setFimg(String fimg) {
        this.fimg = fimg;
    }
}
