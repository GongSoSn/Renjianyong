package com.BKesayGo.Servlet.cn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BKeasyGo.dao.cn.SubDAO;
import com.BKeasyGo.dao.impl.cn.SubDAOImpl;
import com.BKesayGo.bean.cn.Admin;
import com.BKesayGo.bean.cn.Sub;

@WebServlet("/subAddServlet")
public class SubAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取表单元素
        // 商品别名
        String smallClass = req.getParameter("smallClass");
        System.out.println("商品别名:" + smallClass);
        // 商品大分类
        int bigClass = Integer.parseInt(req.getParameter("bigClass"));
        System.out.println("商品大分类:" + bigClass);
        // 封装Sub
        Sub sub = new Sub();
        sub.setS_name(smallClass);
        sub.setS_supid(bigClass);
        // 获取管理员
        HttpSession session = req.getSession(true);
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            sub.setCreate_man(admin.getId());
        }
        // 调用add方法
        SubDAO subDao = new SubDAOImpl();
        int updateCount = subDao.addSub(sub);
        if (updateCount > 0) {
            System.out.println("添加小商品成功 .. ..");
            // 重定向
            resp.sendRedirect("subServlet?page=1");
        }
    }
}
