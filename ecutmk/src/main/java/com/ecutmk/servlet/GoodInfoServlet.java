package com.ecutmk.servlet;

import com.ecutmk.dao.GoodDao;
import com.ecutmk.entity.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( "/good/info" )
public class GoodInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        int good_id = Integer.parseInt(req.getParameter( "good_id" ));
        GoodDao gd=new GoodDao();
        Good g=new Good();
        g=gd.find(good_id);
        session.setAttribute("good",g);
        resp.sendRedirect("/pages/g_info.vm");
    }
}
