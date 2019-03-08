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
import java.io.IOException;
import java.util.List;

@WebServlet( "/list/all" )
public class ListAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        UserDao ud = new UserDao();
        GoodDao td = new GoodDao();
        List<Good> Goods = td.findAll();
        for( Good t : Goods ) {
            User u = t.getUser();
            User user = ud.find( u.getId() );
            t.setUser( user );
        }
        application.setAttribute( "GoodList" , Goods );
        resp.sendRedirect("/index.vm");
    }

}
