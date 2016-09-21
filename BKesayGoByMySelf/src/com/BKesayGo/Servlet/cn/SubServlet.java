package com.BKesayGo.Servlet.cn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BKeasyGo.dao.cn.SubDAO;
import com.BKeasyGo.dao.cn.SupDAO;
import com.BKeasyGo.dao.impl.cn.SubDAOImpl;
import com.BKeasyGo.dao.impl.cn.SupDAOImpl;
import com.BKesayGo.bean.cn.Sub;
import com.BKesayGo.bean.cn.Sup;

@WebServlet("/subServlet")
public class SubServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取page属性
        String pageTemp = req.getParameter("page");
        int page = Integer.parseInt(pageTemp);

        // 调用分页查询方法
        SubDAO subDao = new SubDAOImpl();
        SupDAO supDao = new SupDAOImpl();

        List<Sub> subs = subDao.getSubByPage(page);
        // 获取大分类中对应的数据
        List<Sup> sups = supDao.getSupAll(null, null);


        int count = subs.size();
        System.out.println("Page:" + count);
        // 获取总的页数
        int pageCount = subDao.getPageCount();
        req.setAttribute("PAGE", page);
        req.setAttribute("COUNT", pageCount);
        if (count > 0) {
            req.setAttribute("list", subs);
            req.setAttribute("listSup", sups);
            // 请求转发
            req.getRequestDispatcher("category_manage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
