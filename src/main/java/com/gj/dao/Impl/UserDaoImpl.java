package com.gj.dao.Impl;

import com.gj.dao.UserDao;
import com.gj.domain.AddMenu;
import com.gj.domain.Menu_list;
import com.gj.domain.UserClock;
import com.gj.domain.UserMessage;
import com.gj.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //登录
    @Override
    public UserMessage login(String uname, String upassword) {
        String sql = "select * from user_message where uname = ? and upassword = ?";
        UserMessage user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<UserMessage>(UserMessage.class), uname, upassword);
        } catch (DataAccessException e) {
            //e.printStackTrace();
        }

        return user;
    }
    //检查用户名是否存在
    @Override
    public UserMessage findByUname(String uname) {
        String sql = "select * from user_message where uname = ?";
        UserMessage userMessage = null;
        try {
            userMessage = template.queryForObject(sql, new BeanPropertyRowMapper<UserMessage>(UserMessage.class), uname);
        } catch (DataAccessException e) {
            //e.printStackTrace();
        }
        return userMessage;
    }
    //注册
    @Override
    public void register(UserMessage user) {
        String sql = "insert into user_message values(null,?,?,?)";
        template.update(sql,user.getUname(),user.getUpassword(),user.getUphone());
    }
    //打卡
    @Override
    public void clock(UserClock clock) {
        String sql = "insert into daka values (null,?,?,?,?,?)";
        template.update(sql,clock.getUname(),clock.getTime(),clock.getMeal(),clock.getFoodname(),clock.getAddimg());
    }
    //查询打卡记录
    @Override
    public List<UserClock> fingClock(String uname) {
        String sql = "select * from daka where uname = ?";
        List<UserClock> query = template.query(sql, new BeanPropertyRowMapper<UserClock>(UserClock.class), uname);
        System.out.println(query);
        return query;
    }
    //发布菜谱
    @Override
    public void AddMenu(AddMenu a) {
        String sql = "insert into addmenu values(null,?,?,?,?,?,?,?)";
        template.update(sql,a.getUname(),a.getFoodname(),a.getAddimg(),a.getLearn(),a.getMian(),a.getFuliao(),a.getBuzhou());
    }

    @Override
    public List<AddMenu> MyMenu(String uname) {
        String sql = "select * from addmenu where uname = ?";
        List<AddMenu> mymenu = template.query(sql, new BeanPropertyRowMapper<AddMenu>(AddMenu.class), uname);
        return mymenu;
    }

    @Override
    public List<AddMenu> findMyMenuone(String addid) {
        String sql = "select * from addmenu where addid = ?";
        List<AddMenu> myMenuOne = template.query(sql, new BeanPropertyRowMapper<AddMenu>(AddMenu.class), Integer.parseInt(addid));
        return myMenuOne;
    }

    @Override
    public void DeleDaka(String dakaid) {
        String sql = "delete from daka where dakaid = ?";
        template.update(sql,Integer.parseInt(dakaid));
    }

    @Override
    public void DeleMenu(String addid) {
        String sql = "delete from addmenu where addid = ?";
        template.update(sql,Integer.parseInt(addid));
    }

    @Override
    public void UpdateMenu(AddMenu a) {
        String sql = "update addmenu set foodname = ? ,learn = ?,mian = ?,fuliao = ?,buzhou = ? where addid = ?";
        template.update(sql,a.getFoodname(),a.getLearn(),a.getMian(),a.getFuliao(),a.getBuzhou(),a.getAddid());
    }


}
