package web.servlet;

import com.gj.dao.Impl.UserDaoImpl;
import com.gj.dao.UserDao;
import com.gj.domain.*;
import com.gj.service.Impl.UserServiceImpl;
import com.gj.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/User/*")
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();
    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upassword = request.getParameter("upassword");
        System.out.println(uname+upassword);
        UserMessage userMessage = service.login(uname, upassword);
        ResultInfo info = new ResultInfo();
        if (userMessage != null) {
            //登录成功
            request.getSession().setAttribute("uname", uname);//登录成功标记
            Object uname1 = null;
            uname1 = request.getSession().getAttribute("uname");
            info.setFlag(true);
        } else {
            //用户名密码或错误
            info.setFlag(false);
            info.setErrorMsg("用户名密码或错误");
        }
        writeValue(info, response);
    }
    //注册
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upassword = request.getParameter("upassword");
        String uphone = request.getParameter("uphone");
        //System.out.println(uname+upassword+uphone);
        //2.封装对象
        UserMessage user = new UserMessage();
        user.setUname(uname);
        user.setUpassword(upassword);
        user.setUphone(uphone);
        boolean flag = service.regsiter(user);
        ResultInfo info = new ResultInfo();
        //4.响应结果
        if (flag) {
            //注册成功
            info.setFlag(true);
        } else {
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败!");
        }
        writeValue(info, response);


    }
    //获得登录状态
    public void findone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获取登录用户
        Object uname = request.getSession().getAttribute("uname");
        System.out.println(uname);
        //写回前端
        writeValue(uname, response);
    }
    //退出操作
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁session
        request.getSession().invalidate();
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        writeValue(info, response);
    }

    //打卡
    public void clock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String food = request.getParameter("food");
        String foodname = request.getParameter("foodname");
        String imgs = request.getParameter("imgs");
        Date time = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String t = f.format(time);
        UserClock c = new UserClock();
        c.setUname(uname);
        c.setTime(t);
        c.setMeal(food);
        c.setFoodname(foodname);
        c.setAddimg(imgs);
        service.clock(c);
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        writeValue(info, response);
    }

    //打卡记录
    public void findClock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        List<UserClock> clock = service.findClock(uname);
        System.out.println(clock);
        writeValue(clock, response);
    }

    //发布菜谱
    public void addMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String list = request.getParameter("list");
        String learn = request.getParameter("learn");
        String mian = request.getParameter("mian");
        String fuliao = request.getParameter("fuliao");
        String add = request.getParameter("add");
        String foodname = request.getParameter("foodname");
        //System.out.println(uname+"-"+list+"-"+learn+"-"+main+"-"+fuliao+"-"+add);
        AddMenu a = new AddMenu();
        a.setUname(uname);
        a.setAddimg(list);
        a.setLearn(learn);
        a.setMian(mian);
        a.setFuliao(fuliao);
        a.setBuzhou(add);
        a.setFoodname(foodname);
        service.AddMenu(a);
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        writeValue(info, response);
    }

    //搜索某一用户所有菜谱
    public void findMyMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        List<AddMenu> myMenu = service.findMyMenu(uname);
        System.out.println(myMenu);
        writeValue(myMenu, response);
    }

    //搜索某一用户所有菜谱
    public void findMyMenuOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addid = request.getParameter("addid");
        System.out.println(addid);
        List<AddMenu> myMenuone = service.findMyMenuone(addid);
        System.out.println(myMenuone);
        writeValue(myMenuone, response);
    }

    //删除打卡记录
    public void DeleUserClock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dakaid = request.getParameter("dakaid");
        service.DeleDaka(dakaid);
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        writeValue(info, response);
    }

    //删除发布的菜谱
    public void DeleUserMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addid = request.getParameter("addid");
        service.DeleMenu(addid);
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        writeValue(info, response);
    }

    //删除发布的菜谱
    public void UpdateMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addid = request.getParameter("addid");
        String learn = request.getParameter("learn");
        String mian = request.getParameter("mian");
        String fuliao = request.getParameter("fuliao");
        String buzhou = request.getParameter("buzhou");
        String foodname = request.getParameter("foodname");
        AddMenu a = new AddMenu();
        a.setAddid(Integer.parseInt(addid));
        a.setLearn(learn);
        a.setMian(mian);
        a.setFuliao(fuliao);
        a.setBuzhou(buzhou);
        a.setFoodname(foodname);
        service.UpdateMenu(a);
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        writeValue(info, response);
    }

}
