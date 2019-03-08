package com.ecutmk.servlet;


import com.ecutmk.dao.GoodDao;
import com.ecutmk.dao.UserDao;
import com.ecutmk.entity.Good;
import com.ecutmk.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet( "/kind/list" )
public class KindListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        UserDao ud = new UserDao();
        GoodDao gd = new GoodDao();
        String good_kind=req.getParameter("good_kind");
        List<Good> Goods = gd.kindfind(good_kind);
        for( Good g : Goods ) {
            User u = g.getUser();
            User user = ud.find( u.getId() );
            g.setUser( user );
        }
        application.setAttribute( "GoodList" , Goods );
        resp.sendRedirect("/index.vm");
    }


}


