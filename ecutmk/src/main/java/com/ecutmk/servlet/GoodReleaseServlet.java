package com.ecutmk.servlet;

import com.ecutmk.dao.GoodDao;
import com.ecutmk.dao.UserDao;
import com.ecutmk.entity.Good;
import com.ecutmk.entity.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.net.URLEncoder;


@WebServlet("/good/release")
@MultipartConfig(location = "D:/images")
public class GoodReleaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("不支持GET方式上传图片");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");

        HttpSession session = req.getSession(); // 获得与当前请求关联的会话对象
        UserDao ud = new UserDao();
        User u = new User();
        u = (User) session.getAttribute("user");
        GoodDao gd = new GoodDao();
        Good g = new Good();

        String summary = req.getParameter("summary");
        String explain = req.getParameter("explain");
        double price = Double.parseDouble(req.getParameter("price"));
        String kind = req.getParameter("kind");
        String picture1 = req.getParameter("picture1");
        String picture2 = req.getParameter("picture2");
        String picture3 = req.getParameter("picture3");
        String picture4 = req.getParameter("picture4");

        g.setGood_kind(kind);
        g.setGood_explain(explain);
        g.setGood_summary(summary);
        g.setGood_price(price);
        g.setGood_owner(u.getId());
        g.setUser(u);


        String na = "upfile";
        g = write(req, na, g);
        gd.save(g);
        g.getUser().setCount_good(g.getUser().getCount_good() + 1);
        ud.update(g.getUser());
        resp.sendRedirect( "/pages/p_info.vm");

    }

    private Good write(HttpServletRequest req, String up, Good g) {


            try {
                    for (int i = 1; i <= 4; i++) {
                        String temp=up+i;
                            Part p = req.getPart(temp); // <input type="file" name="upfile">
                        System.out.println(temp);
                            if (p != null && p.getSize() > 0) {
                                String extension = ".jpg";
                                String filename = g.getUser().getId() + "-" + g.getUser().getCount_good() + "-" + i + extension;


                                p.write(filename);
                                switch (i){
                                    case 1: g.setGood_picture1(filename);break;
                                    case 2:g.setGood_picture2(filename);break;
                                    case 3:g.setGood_picture3(filename);break;
                                    case 4:g.setGood_picture4(filename);break;
                                    default:System.out.println("图片上传出现异常！");

                                }
                                System.out.println(i);
                            }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        return g;
    }
}


