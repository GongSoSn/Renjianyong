package com.BKesayGo.Servlet.cn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BKeasyGo.dao.cn.SupDAO;
import com.BKeasyGo.dao.impl.cn.SupDAOImpl;
import com.BKesayGo.bean.cn.Sup;

@WebServlet("/showSupListServlet")
public class ShowSupListServlet extends HttpServlet {
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
        // 封装大分类信息
        SupDAO supDao = new SupDAOImpl();
        List<Sup> sups = supDao.getSupAll(null, null);
        int count = sups.size();
        if (count > 0) {
            // 设置属性之后请求转发
            req.setAttribute("sups", sups);
            req.getRequestDispatcher("category_modify.jsp").forward(req, resp);
        }
    }
}


