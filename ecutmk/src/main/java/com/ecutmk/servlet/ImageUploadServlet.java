package com.ecutmk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet( "/image/upload" )
@MultipartConfig( location = "D:/images" )
public class ImageUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType( "text/plain;charset=UTF-8" );
        PrintWriter w = resp.getWriter();
        w.println( "不支持GET方式上传图片" );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType( "text/plain;charset=UTF-8" );
        //PrintWriter w = resp.getWriter();

        // 从 表单上获取 <input type="file" > 组件对应的对象
        Part p = req.getPart( "upfile" ); // <input type="file" name="upfile">

        if( p != null && p.getSize() > 0 ) {
            String filename = p.getSubmittedFileName();
            p.write( filename );
            resp.sendRedirect( "/image/show?filename=" + URLEncoder.encode( filename , "UTF-8") );
        }

        // w.println( "图片上传成功" );

    }
}
