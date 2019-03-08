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


@WebServlet("/message/issue")
public  class MessageIssueServlet extends DispatcherServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ; // 获取当前请求关联的会话对象
        ServletContext application = req.getServletContext();
        // 从会话对象中获取已经登录的 User 对象
        Object o = session.getAttribute( "user" );
        Object ob = session.getAttribute("good");


        //在哪个商品下就是哪个商品
        Good g = (Good) ob;
        System.out.println(g.getGood_id());
        if( o instanceof User) {
            User u = (User) o;

            String content = req.getParameter("content");


            Message m = new Message();
            m.setGood(g);
            m.setUser(u);
            m.setM_content(content);

            MessageDao md = new MessageDao();
            md.save(m);
            resp.sendRedirect("/message/list");



        }else {
            this.redirect( req , resp , "/pages/sign-in.vm" , "fail" , "不能发起留言");
        }



    }


}
