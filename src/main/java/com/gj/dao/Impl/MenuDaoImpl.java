package com.gj.dao.Impl;

import com.gj.dao.MenuDao;
import com.gj.domain.Food_buzhou;
import com.gj.domain.Menu_list;
import com.gj.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuDaoImpl implements MenuDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //首页展示
    @Override
    public List<Menu_list> findAll() {
        String sql = "select * from menu_list";
        List<Menu_list> all = template.query(sql, new BeanPropertyRowMapper<Menu_list>(Menu_list.class));
        return all;
    }
    //首页点击详细
    @Override
    public List<Food_buzhou> findById(String fid) {
        int fid1 = Integer.parseInt(fid);
        String sql = "select * from food_buzhou where fid = ?";
        List<Food_buzhou> food_buzhous = template.query(sql, new BeanPropertyRowMapper<Food_buzhou>(Food_buzhou.class), fid1);

        return food_buzhous;
    }
    //搜索
    @Override
    public List<Food_buzhou> SearchByFname(String fname) {

        String sql = "select * from food_buzhou where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        sb.append(" and fname like ? ");
        String res = "%"+fname+"%";
        sql = sb.toString();
        //System.out.println(sql);
        //System.out.println(res);
        List<Food_buzhou> searchOne = template.query(sql, new BeanPropertyRowMapper<Food_buzhou>(Food_buzhou.class), res);
        return searchOne;
    }
    //收藏
    @Override
    public void Collect(String uname,String fid) {
        String sql = "insert into Collect values (?,?)";
        template.update(sql,Integer.parseInt(fid),uname);
    }

    @Override
    public List<Menu_list> findSort(String sortid) {
        String sql = "select * from menu_list where sortid = ?";
        List<Menu_list> sort = template.query(sql, new BeanPropertyRowMapper<Menu_list>(Menu_list.class), Integer.parseInt(sortid));
        return sort;
    }

}
