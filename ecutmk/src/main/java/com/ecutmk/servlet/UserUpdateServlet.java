package com.ecutmk.servlet;

import com.ecutmk.dao.UserDao;
import com.ecutmk.entity.User;
import com.ecutmk.helper.EncryptHelper;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/update")
public class UserUpdateServlet extends DispatcherServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String url = "/pages/refactor.vm"; // 确定更新失败后去往哪里
        HttpSession session = req.getSession(); // 获得与当前请求关联的会话对象

        String passwd = req.getParameter("password");
        if (passwd == null || passwd.trim().isEmpty()) {
            this.redirect(req, resp, url, "fail", "密码不能为空，请重新输入");
            return;
        }

        String confirm = req.getParameter("confirm");
        if (confirm == null || confirm.trim().isEmpty()) {
            this.redirect(req, resp, url, "fail", "请再次输入密码");
            return;
        }

        String phonenumber = req.getParameter("phonenumber");
        if (phonenumber == null || phonenumber.trim().isEmpty()) {
            this.redirect(req, resp, url, "fail", "电话号码不能为空，请重新输入");
            return;
        }

        passwd = passwd.trim(); // 剔除首尾空白
        confirm = confirm.trim();

        // 判断密码是否不一致 ( 注意这里有个感叹号 )
        if (!passwd.equals(confirm)) {
            this.redirect(req, resp, url, "fail", "两次输入密码不一致，请重新输入");
            return;
        }

        UserDao ud = new UserDao();

        passwd = EncryptHelper.encrypt(passwd.trim()); // 对密码进行加密

        User user = new User();
        user=(User)session.getAttribute("user");
        user.setPassword(passwd);
        user.setPhone(phonenumber);
        boolean x = ud.update(user);
        if (x) {
            this.redirect(req, resp, url, "fail", "更新成功");
        } else {
            this.redirect(req, resp, url, "fail", "更新失败，请重试");
        }
    }


}

