/**
 *
 */
package com.BKesayGo.Servlet.cn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BKeasyGo.dao.impl.cn.UserDAOImpl;
import com.BKesayGo.bean.cn.Sysuser;

/**
 * @author Renjianyong
 *
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获取page属性
        String pageStr = req.getParameter("page");
        System.out.println(pageStr);
        int page = Integer.parseInt(pageStr);
        System.out.println("当前页：" + page);
        UserDAOImpl userDao = new UserDAOImpl();
        List<Sysuser> list = userDao.getUsersByPage(page);
        // 获取总页数
        int pageCount = userDao.getPageCount();
        System.out.println("总页数 ： " + pageCount);

        req.setAttribute("list", list);
        // 传递分页相关的属性
        req.setAttribute("PAGE", page);
        req.setAttribute("PAGECOUNT", pageCount);

        System.out.println("查询结果 ： " + list.size());
        req.getRequestDispatcher("user_manage.jsp").forward(req, resp);
    }
}
