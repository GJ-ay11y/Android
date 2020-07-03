package com.gj.dao;

import com.gj.domain.Food_buzhou;
import com.gj.domain.Menu_list;

import java.util.List;
import java.util.Map;

public interface MenuDao {
    //首页列表
    public List<Menu_list> findAll();
    //详情
    public List<Food_buzhou> findById(String fid);
    //搜索
    public List<Food_buzhou> SearchByFname(String fname);
    //收藏
    public void Collect(String uname,String fid);
    //分类
    public List<Menu_list> findSort(String sortid);



}