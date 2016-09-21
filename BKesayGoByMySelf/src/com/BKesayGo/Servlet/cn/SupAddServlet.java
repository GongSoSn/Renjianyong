package com.BKesayGo.Servlet.cn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BKeasyGo.dao.cn.SupDAO;
import com.BKeasyGo.dao.impl.cn.SupDAOImpl;
import com.BKesayGo.bean.cn.Admin;
import com.BKesayGo.bean.cn.Sup;

@WebServlet("/supAdd")
public class SupAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获取表单数据
        String className = req.getParameter("className");
        // 获取管理员
        HttpSession session = req.getSession(true);
        Admin admin = (Admin) session.getAttribute("admin");
        // 封装对象
        Sup sup = new Sup();
        sup.setS_supname(className);
        sup.setCreate_man(admin.getId());

        // 调用add方法
        SupDAO dao = new SupDAOImpl();
        int count = dao.addSup(sup);
        System.out.println("添加的行数 : " + count);
        if (count > 0) {
            System.out.println("添加成功 .. ..");
            req.getRequestDispatcher("supServlet?page=1").forward(req, resp);
        }
    }
}
