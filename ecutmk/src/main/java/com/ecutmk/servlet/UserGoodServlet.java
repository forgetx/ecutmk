package com.ecutmk.servlet;


import com.ecutmk.dao.GoodDao;
import com.ecutmk.dao.UserDao;
import com.ecutmk.entity.Good;
import com.ecutmk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet( "/user/good" )
public class UserGoodServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u=new User();
        UserDao ud=new UserDao();
        u = (User) session.getAttribute("user");
        GoodDao gd=new GoodDao();
        System.out.println("下面是用户id");
        System.out.println(u.getId());
        List<Good> goods=gd.userfind(u.getId());
        for( Good t : goods ) {
            User user = ud.find( u.getId() );
            t.setUser( user );
        }
        session.setAttribute( "MyGoods" , goods );
        System.out.println("下面是跳转");
        resp.sendRedirect("/pages/p_info.vm");

    }
}
