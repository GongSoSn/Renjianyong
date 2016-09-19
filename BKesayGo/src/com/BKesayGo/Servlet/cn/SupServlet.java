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

import com.BKeasyGo.dao.impl.cn.SupDAOImpl;
import com.BKesayGo.bean.cn.Sup;

/**
 * @author Renjianyong
 *
 */
@WebServlet("/supServlet")
public class SupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取page属性进行分页
        String pageTemp = req.getParameter("page");
        int page = Integer.parseInt(pageTemp);
        System.out.println("page:" + page);
        // 进行分页查询
        SupDAOImpl dao = new SupDAOImpl();
        // 查询总页数
        int pageCount = dao.getPageCount();
        List<Sup> supList = dao.getSupByPage(page);
        System.out.println("查询结果的集合 :" + supList.size());
        req.setAttribute("PAGE", page);
        req.setAttribute("COUNT", pageCount);
        req.setAttribute("list", supList);
        req.getRequestDispatcher("class_manage.jsp").forward(req, resp);
    }
}
