package com.ecutmk.servlet;

import com.ecutmk.dao.GoodDao;
import com.ecutmk.dao.UserDao;
import com.ecutmk.entity.Good;
import com.ecutmk.entity.User;

import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;

@WebServlet( urlPatterns = "/prepared" , loadOnStartup = 2 )
public class PreparedServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println( "PreparedServlet 初始化" );
        // 获取 当前 Servlet 的上下文 ( context )对象 ( 与JSP中的 application 对象是同一个对象)
        ServletContext application = this.getServletContext();

        // 创建 UserDao 对象
        UserDao ud = new UserDao();
        // 创建 TopicDao 对象
        GoodDao td = new GoodDao();

        // 查询数据库中所有的 Topic 并返回一个由 Topic 组成的 List 集合
        List<Good> Goods = td.findAll();

        // 迭代 topics 集合，处理每个话题的 提问者
        for( Good t : Goods ) {
            User u = t.getUser();
            User user = ud.find( u.getId() );
            t.setUser( user );
        }

        // 将查询得到的 List 集合设置到 application 中
        application.setAttribute( "GoodList" , Goods );

    }

}
