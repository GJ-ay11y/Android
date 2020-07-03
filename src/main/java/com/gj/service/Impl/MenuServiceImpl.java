package com.gj.service.Impl;

import com.gj.dao.Impl.MenuDaoImpl;
import com.gj.dao.MenuDao;
import com.gj.domain.Food_buzhou;
import com.gj.domain.Menu_list;
import com.gj.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuServiceImpl implements MenuService {
    private MenuDao dao = new MenuDaoImpl();
    //首页展示
    @Override
    public List<Menu_list> findAll() {
        List<Menu_list> all = dao.findAll();
        return all;
    }
    //步骤展示
    @Override
    public List<Food_buzhou> findById(String fid) {
        List<Food_buzhou> food_buzhous = dao.findById(fid);
        return food_buzhous;
    }
    //搜索
    @Override
    public List<Food_buzhou> searchByFname(String fname) {
        List<Food_buzhou> searchOne = dao.SearchByFname(fname);
        return searchOne;
    }
    //收藏
    @Override
    public void Collect(String uname,String fid) {
        dao.Collect(uname,fid);
    }

    @Override
    public List<Menu_list> findSort(String sortid) {
        List<Menu_list> sort = dao.findSort(sortid);
        return sort;
    }
}
