package com.BKesayGo.Servlet.cn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BKeasyGo.dao.cn.UserDAO;
import com.BKeasyGo.dao.impl.cn.UserDAOImpl;
import com.BKesayGo.bean.cn.Admin;
import com.BKesayGo.bean.cn.Sysuser;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获取请求参数
        String userName = req.getParameter("userName");
        String trueName = req.getParameter("name");
        String password = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String birthDay = req.getParameter("birthDay");
        String identify = req.getParameter("user_id");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        // 封装属性到对象中
        Sysuser user = new Sysuser();
        // 获取外键
        HttpSession session = req.getSession(true);
        Admin admin = (Admin) session.getAttribute("admin");
        // user.setCreate_time(create_time);
        // user.setS_id(s_id);
        System.out.println("外键： " + admin.getId());
        user.setS_username(userName);
        user.setS_truename(trueName);
        user.setS_pwd(password);
        user.setS_sex(Integer.parseInt(sex));
        user.setS_birth(birthDay);
        user.setS_idcard(identify);
        user.setS_email(email);
        user.setS_phone(phone);
        user.setS_address(address);
        user.setS_if(0);
        user.setCreate_man(admin.getId()); // 设置外键
        // user.setUpdate_man(update_man);
        // user.setUpdate_time(update_time);

        UserDAO userDao = new UserDAOImpl();

        int count = userDao.addUser(user);

        // 判断是否更新了数据
        if (count > 0) {
            System.out.println("更新成功 .. ..");
        }
        // 转发到查询的逻辑中
        req.getRequestDispatcher("users?page=1").forward(req, resp);
    }
}


