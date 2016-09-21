package com.BKesayGo.Servlet.cn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BKeasyGo.dao.cn.BulletinDao;
import com.BKeasyGo.dao.impl.cn.BulletinDAOImpl;
import com.BKesayGo.bean.cn.Bulletin;

@WebServlet("/announcementServlet")
public class AnnouncementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取page
        int page = Integer.parseInt(req.getParameter("page"));
        // 从数据库获取公告信息
        BulletinDao bDao = new BulletinDAOImpl();
        // 获取pageCount
        int pageCount = bDao.getpageCount();
        List<Bulletin> bs = bDao.getBulletinByPage(page);
        int count = bs.size();
        if (count > 0) {
            // setAttrbute
            req.setAttribute("page", page);
            req.setAttribute("count", pageCount);
            req.setAttribute("bs", bs);
            // 转发
            req.getRequestDispatcher("announcement_manage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
