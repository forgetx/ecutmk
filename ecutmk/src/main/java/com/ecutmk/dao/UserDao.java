package com.ecutmk.dao;

import com.ecutmk.entity.User;
import com.ecutmk.helper.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean save( User u ) {
        JdbcHelper h = JdbcHelper.getInstance();
        String SQL = "INSERT INTO user ( user_name , user_password ,user_phone ) VALUES ( ? , ? ,?)" ;
        int count = h.update( SQL , u.getUsername() , u.getPassword() ,u.getPhone());
        h.release();
        return count == 1 ;
    }

    public boolean update( User u ) {
        JdbcHelper h = JdbcHelper.getInstance();
        String SQL = "UPDATE  user SET user_password=? ,user_phone=?,user_count_msg=?,user_count_good=? WHERE user_id=?" ;
        int count = h.update( SQL , u.getPassword() ,u.getPhone(),u.getCount_msg(),u.getCount_good(),u.getId());
        h.release();
        return count == 1 ;
    }
    /**
     * 根据用户名查询数据库并返回一个User对象
     * @param username 需要查询的用户名
     * @return 返回username对应的数据库记录对应的User对象
     */
    public User find( String username ) {
        String SQL = "SELECT user_id , user_name , user_password , user_phone , user_count_msg , user_count_good FROM user WHERE user_name = ? " ;
        return this.find( SQL , username );
    }

    public User find( int id ) {
        String SQL = "SELECT user_id , user_name , user_password , user_phone , user_count_msg ,user_count_good FROM user WHERE user_id = ? " ;
        return this.find( SQL , id );
    }

    private User find( String query , Object param ) {
        User u = null ; // 声明一个 User 类型的变量，用来保存 User 对象

        JdbcHelper h = JdbcHelper.getInstance();
        ResultSet rs = h.query( query , param );
        try {
            if( rs.next() ) {
                u = this.wrap( rs );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        h.release( rs );
        h.release();
        return u ;
    }

    private User wrap( ResultSet rs ) {
        User u = new User();
        try {
            u.setId( rs.getInt( "user_id" ) ); // 将从数据库中查询到的 id 设置到 User 对象的 id 属性中
            u.setUsername( rs.getString( "user_name" ) );
            u.setPassword( rs.getString( "user_password" ) );
            u.setPhone( rs.getString( "user_phone" ) );
            u.setCount_msg(rs.getInt("user_count_msg"));
            u.setCount_good(rs.getInt("user_count_good"));
        } catch ( SQLException ex ) {
            ex.printStackTrace();
        }
        return u ;
    }

    /**
     *  查询用户是否存在
     * @param username 被查询的用户名
     * @return 如果指定用户名已经在数据库表中存在就返回 true，否则就返回 false
     */
    public boolean exists( String username ) {
        boolean e = false ; // 假设 username 在数据库中不存在
        JdbcHelper h = JdbcHelper.getInstance();
        ResultSet rs = h.query( "SELECT user_id FROM user WHERE user_name = ? " , username );
        try {
            e = rs.next(); // 当结果集中第一行存在数据时，返回 true，否则返回 false
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        h.release();
        return e ;
    }


}
