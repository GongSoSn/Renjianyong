/**
 *
 */
package com.BKesayGo.Servlet.cn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BKeasyGo.dao.impl.cn.AdminDAOImpl;
import com.BKesayGo.bean.cn.Admin;

/**
 * @author Renjianyong
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
        // 获取验证信息
        String userName = req.getParameter("userName");
        String password = req.getParameter("pwd");
        // 获取验证码(图片中)
        String identfyCode = (String) req.getSession()
                .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        // 获取验证码(输入框)
        String inputCode = req.getParameter("idenfitying");
        // 获取CheckBox
        String flag = req.getParameter("flag");
        // System.out.println(flag);

        // 验证
        AdminDAOImpl admin = new AdminDAOImpl();
        Object[] obj = {userName, password};
        List<Admin> list = admin.queryAdmin(obj);
        if (list.size() == 1 && identfyCode.equals(inputCode)) {
            if ("Yes".equals(flag)) {
                Cookie name = new Cookie("userName", userName);
                Cookie pass = new Cookie("password", password);
                name.setMaxAge(60 * 60 * 24);
                pass.setMaxAge(60 * 60 * 24);
                resp.addCookie(name);
                resp.addCookie(pass);
                System.out.println("Cookie");
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("admin", list.get(0));
            req.getRequestDispatcher("index.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
