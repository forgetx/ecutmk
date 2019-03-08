package com.ecutmk.servlet;

import com.ecutmk.dao.UserDao;
import com.ecutmk.entity.User;
import com.ecutmk.helper.EncryptHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( "/user/sign/up" )
public class UserSignUpServlet extends DispatcherServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String url = "/pages/sign-up.vm" ; // 确定注册失败后去往哪里
        HttpSession session = req.getSession() ; // 获得与当前请求关联的会话对象

        /** 接受来自页面的数据 **/
        String uname = req.getParameter( "username" ); // <input type="text" name="username" placeholder="请输入用户名">
        if( uname == null || uname.trim().isEmpty() ) {
            // 将提示信息保存到会话对象中；重定向 ( redirect ) 到注册页面 ( /pages/sign-up.vm )
            this.redirect( req , resp , url , "fail" , "用户名不能为空，请重新输入");
            return ; // 让 service 方法立即返回 ( 后续所有代码不再执行 )
        }

        String passwd = req.getParameter( "password" );
        if( passwd == null || passwd.trim().isEmpty() ) {
            this.redirect( req , resp , url , "fail" , "密码不能为空，请重新输入");
            return ;
        }

        String confirm = req.getParameter( "confirm" );
        if( confirm == null || confirm.trim().isEmpty() ) {
            this.redirect( req , resp , url , "fail" , "请再次输入密码");
            return ;
        }

        String phonenumber = req.getParameter( "phonenumber" );
        if( phonenumber == null || phonenumber.trim().isEmpty() ) {
            this.redirect( req , resp , url , "fail" , "电话号码不能为空，请重新输入");
            return ;
        }

        passwd = passwd.trim() ; // 剔除首尾空白
        confirm = confirm.trim() ;

        // 判断密码是否不一致 ( 注意这里有个感叹号 )
        if( ! passwd.equals( confirm ) ) {
            this.redirect( req , resp , url , "fail" , "两次输入密码不一致，请重新输入");
            return ;
        }

        String code = req.getParameter( "code" );
        if( code == null || code.trim().isEmpty() ) {
            this.redirect( req , resp , url , "fail" , "验证码不能为空");
            return ;
        }

        //  从 会话对象中获取 名称是 IDENTITY_CODE 的变量(属性)的取值
        String identityCode = (String)session.getAttribute( "IDENTITY_CODE" );
        code = code.trim(); // 剔除用户在页面上输入的验证码的首尾空白
        // 比较 用户输入的验证码 根 会话对象中存储的验证码 是否不相同
        // 注意，这里有感叹号；注意，比较验证码时不需要区分大小写
        if( ! code.equalsIgnoreCase( identityCode ) ) {
            this.redirect( req , resp , url , "fail" , "验证码错误，请重新输入");
            return ;
        }

        UserDao ud = new UserDao();

        boolean e = ud.exists( uname );
        if( e ) {
            this.redirect( req , resp , url , "fail" , "用户名 " + uname + " 已经被占用" );
            return ;
        }

        passwd = EncryptHelper.encrypt( passwd.trim() ); // 对密码进行加密

        User user = new User();
        user.setUsername( uname.trim() );
        user.setPassword( passwd );
        user.setPhone(phonenumber);

        boolean x = ud.save( user );
        if( x ) {
            this.redirect( req , resp , "/pages/sign-in.vm" , "success" , "注册成功" );
        } else {
            this.redirect( req , resp , url , "fail" , "注册失败，请重试" );
        }
    }

}
