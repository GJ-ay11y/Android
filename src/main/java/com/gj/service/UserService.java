package com.gj.service;

import com.gj.domain.AddMenu;
import com.gj.domain.Menu_list;
import com.gj.domain.UserClock;
import com.gj.domain.UserMessage;

import java.util.List;

public interface UserService {
    //登录
    public UserMessage login(String uname,String upassword);
    //注册
    public boolean regsiter(UserMessage user);
    //打卡
    public void clock(UserClock clock);
    //打卡记录
    public List<UserClock> findClock(String uname);
    //发布菜谱
    public void AddMenu(AddMenu a);
    //搜索用户发布所有菜谱
    public List<AddMenu> findMyMenu(String uname);
    //搜索某一用户某一菜谱
    public List<AddMenu> findMyMenuone(String addid);

    //删除打卡记录
    public void DeleDaka(String dakaid);
    //删除用户发布的菜谱
    public void DeleMenu(String addid);
    //修改菜谱
    public void UpdateMenu(AddMenu a);

}
