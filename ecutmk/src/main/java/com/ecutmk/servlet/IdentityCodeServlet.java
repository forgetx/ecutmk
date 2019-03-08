package com.ecutmk.servlet;

import com.ecutmk.helper.GraphicHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet( "/identity/code/*" )
public class IdentityCodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ; // 获得与当前请求关联的会话对象

        // 获得可以向浏览器发送字节数据的输出流
        OutputStream out = resp.getOutputStream();

        // 使用 GraphicHelper 类的 create 方法创建图片验证码
        String identityCode = GraphicHelper.create( 4 , false, 180 , 50 , out , 20 );

        // 将 产生的 图片验证码上面的 内容 保存到会话对象中
        session.setAttribute( "IDENTITY_CODE" , identityCode );

        System.out.println( "生成验证码: " + identityCode  );

    }

}
