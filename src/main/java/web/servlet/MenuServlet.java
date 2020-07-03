package web.servlet;

import com.gj.domain.Food_buzhou;
import com.gj.domain.Menu_list;
import com.gj.domain.ResultInfo;
import com.gj.service.Impl.MenuServiceImpl;
import com.gj.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/Menu/*")
public class MenuServlet extends BaseServlet {
    private MenuService service = new MenuServiceImpl();
    //首页展示
    public void menulist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Menu_list> all = service.findAll();
        writeValue(all,response);
    }
    //步骤展示
    public void menuFindOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fid = request.getParameter("fid");
        //System.out.println(fid);
        List<Food_buzhou> food = service.findById(fid);
        //System.out.println(food);
        writeValue(food,response);
    }
    //搜索
    public void menuSearchOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fname = request.getParameter("fname");
        System.out.println(fname);
        List<Food_buzhou> searchOne = service.searchByFname(fname);
        //System.out.println(searchOne);
        writeValue(searchOne,response);
    }
    //分类
    public void Sort(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sortid = request.getParameter("sortid");
        List<Menu_list> sort = service.findSort(sortid);
        writeValue(sort,response);
    }
}
