package com.ecutmk.dao;

import com.ecutmk.entity.Good;
import com.ecutmk.entity.User;
import com.ecutmk.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDao {
    //ok----------------------
    public boolean save(Good g)
    {
        JdbcHelper h=JdbcHelper.getInstance();//获取jdbc支持
        String SQL="INSERT INTO good ( good_owner,good_kind,good_summary,good_explain,good_price,good_picture1,good_picture2,good_picture3,good_picture4) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
        int count=h.update( SQL , g.getGood_owner(),g.getGood_kind(),g.getGood_summary(),g.getGood_explain() ,g.getGood_price(),g.getGood_picture1(),g.getGood_picture2(),g.getGood_picture3(),g.getGood_picture4());
        h.release();
        return count==1;
    }

    //ok---------------------
    public Good find(int good_id )
    {
        Good good = null ;
        String SQL = "SELECT * FROM good WHERE good_id = ? " ;
        JdbcHelper h = JdbcHelper.getInstance();
        ResultSet rs = h.query( SQL , good_id );
        try {
            if( rs.next() ) {
                good = new Good();
                good=wrap(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        h.release();
        return good ;
    }

    public List<Good> userfind(int good_owner) {

        List<Good> Goods = new ArrayList<>();

        String SQL = "SELECT good_id,good_owner,good_kind,good_summary,good_explain,good_price,good_picture1,good_picture2,good_picture3,good_picture4 FROM good WHERE good_owner=?" ;

        JdbcHelper h = JdbcHelper.getInstance();
        ResultSet rs = h.query( SQL,good_owner);
        try {
            while (rs.next()) {
                Good g = this.wrap(rs);
                Goods.add(g);
            }
        } catch ( SQLException ex ) {
            ex.printStackTrace();
        }
        h.release( rs );
        h.release();

        return Goods ;
    }

    public List<Good> kindfind(String good_kind) {

        List<Good> Goods = new ArrayList<>();

        String SQL = "SELECT good_id,good_owner,good_kind,good_summary,good_explain,good_price,good_picture1,good_picture2,good_picture3,good_picture4 FROM good WHERE good_kind=?" ;

        JdbcHelper h = JdbcHelper.getInstance();
        ResultSet rs = h.query( SQL,good_kind);
        try {
            while (rs.next()) {
                Good g = this.wrap(rs);
                Goods.add(g);
            }
        } catch ( SQLException ex ) {
            ex.printStackTrace();
        }
        h.release( rs );
        h.release();

        return Goods ;
    }


    public List<Good> findAll() {

        List<Good> Goods = new ArrayList<>();

        String SQL = "SELECT good_id,good_owner,good_kind,good_summary,good_explain,good_price,good_picture1,good_picture2,good_picture3,good_picture4 FROM good " ;

        JdbcHelper h = JdbcHelper.getInstance();
        ResultSet rs = h.query( SQL);
        try {
            while (rs.next()) {
                Good g = this.wrap(rs);
                Goods.add(g);
            }
        } catch ( SQLException ex ) {
            ex.printStackTrace();
        }
        h.release( rs );
        h.release();

        return Goods ;
    }
   /*public List<Good> find(String finded)
    {
        List<Good> good = new ArrayList<>();
        String SQL = "SELECT * FROM user WHERE good_summary = *?* " ;
        JdbcHelper h = JdbcHelper.getInstance();
        ResultSet rs = h.query( SQL , finded);
        try {
            while( rs.next() ) {
                Good g=this.wrap(rs);
                good.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        h.release(rs);
        h.release();
        return good ;
    }*/

    //ok---------------------
    private Good wrap( ResultSet rs ) {
        Good good=new Good();
        try
        {
            good.setGood_id(rs.getInt("good_id"));
            good.setGood_owner(rs.getInt("good_owner"));
            good.setGood_kind(rs.getString("good_kind"));
            good.setGood_summary(rs.getString("good_summary"));
            good.setGood_explain(rs.getString("good_explain"));
            good.setGood_price(rs.getDouble("good_price"));
            good.setGood_picture1(rs.getString("good_picture1"));
            good.setGood_picture2(rs.getString("good_picture2"));
            good.setGood_picture3(rs.getString("good_picture3"));
            good.setGood_picture4(rs.getString("good_picture4"));
            User u = new User();
            u.setId(rs.getInt("good_owner"));
            good.setUser(u);
        }catch ( SQLException e ) {
            e.printStackTrace();
        }
        return good;
    }
}
