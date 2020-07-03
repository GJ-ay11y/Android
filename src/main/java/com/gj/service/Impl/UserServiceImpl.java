package com.gj.service.Impl;

import com.gj.dao.Impl.UserDaoImpl;
import com.gj.dao.UserDao;
import com.gj.domain.AddMenu;
import com.gj.domain.Menu_list;
import com.gj.domain.UserClock;
import com.gj.domain.UserMessage;
import com.gj.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    //登录
    @Override
    public UserMessage login(String uname, String upassword) {
        UserMessage u = dao.login(uname, upassword);
        return u;
    }
    //注册
    @Override
    public boolean regsiter(UserMessage user) {
        UserMessage byUname = dao.findByUname(user.getUname());
        if(byUname != null){
            //用户名已存在
            return false;
        }
        dao.register(user);
        return true;
    }
    //打卡
    @Override
    public void clock(UserClock clock) {
        dao.clock(clock);
    }
    //打卡记录
    @Override
    public List<UserClock> findClock(String uname) {
        List<UserClock> userClocks = dao.fingClock(uname);
        return userClocks;
    }
    //添加菜品
    @Override
    public void AddMenu(AddMenu a) {
        dao.AddMenu(a);
    }
    //查询菜品
    @Override
    public List<AddMenu> findMyMenu(String uname) {
        List<AddMenu> myMenu = dao.MyMenu(uname);
        return myMenu;
    }

    @Override
    public List<AddMenu> findMyMenuone(String addid) {
        List<AddMenu> myMenuone = dao.findMyMenuone(addid);
        return myMenuone;
    }

    @Override
    public void DeleDaka(String dakaid) {
        dao.DeleDaka(dakaid);
    }

    @Override
    public void DeleMenu(String addid) {
        dao.DeleMenu(addid);
    }

    @Override
    public void UpdateMenu(AddMenu a) {
        dao.UpdateMenu(a);
    }
}
