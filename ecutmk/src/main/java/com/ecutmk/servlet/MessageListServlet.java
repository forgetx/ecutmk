package com.ecutmk.servlet;

import com.ecutmk.dao.GoodDao;
import com.ecutmk.dao.MessageDao;
import com.ecutmk.dao.UserDao;
import com.ecutmk.entity.Good;
import com.ecutmk.entity.Message;
import com.ecutmk.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/message/list")
public  class MessageListServlet extends DispatcherServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ;
        ServletContext application = req.getServletContext();
        Object ob = session.getAttribute("good");

        //在哪个商品下就是哪个商品
        Good g = (Good) ob;
        UserDao ud = new UserDao();
        GoodDao gd =new GoodDao();
        MessageDao messageDao =new MessageDao();

        List<Message> messages=messageDao.find(g.getGood_id());


        for(Message me : messages)
        {
            User us= me.getUser();
            User use = ud.find(us.getId());
            me.setUser(use);
            Good go = me.getGood();
            Good good = gd.find(go.getGood_id());
            me.setGood(good);


        }
        application.setAttribute( "messages" , messages );
        resp.sendRedirect("/pages/g_info.vm");


    }


}
