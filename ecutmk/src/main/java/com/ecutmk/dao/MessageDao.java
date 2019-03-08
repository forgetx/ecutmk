package com.ecutmk.dao;

import com.ecutmk.entity.Good;
import com.ecutmk.entity.Message;
import com.ecutmk.entity.User;
import com.ecutmk.helper.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {

        public boolean save(Message m ) {
            JdbcHelper h = JdbcHelper.getInstance();
            String SQL = "INSERT INTO message ( m_user ,m_good ,m_content ) VALUES ( ? , ? ,?)" ;

            int count = h.update( SQL , m.getUser().getId() , m.getGood().getGood_id(),m.getM_content() );
            h.release();
            return count == 1 ;
    }



    public List<Message> find(int id ){

        List<Message> messages =new ArrayList<>();

        String SQL = "SELECT m_id , m_user ,m_good ,m_content,m_date FROM message WHERE m_good = ? " ;

        JdbcHelper h = JdbcHelper.getInstance();
        ResultSet rs = h.query( SQL , id );
        try {
            while (rs.next()) {
                Message m=this.wrap(rs);
                messages.add(m);

            }
        } catch ( SQLException ex ){
            ex.printStackTrace();
        }
        h.release( rs );
        h.release();
        return messages;
    }



    private Message wrap(ResultSet rs ) {
        Message m = new Message();
        try {
            m.setM_id(rs.getInt("m_id"));

            m.setM_date(rs.getTimestamp("m_date"));
            m.setM_content(rs.getString("m_content"));
            int userId = rs.getInt("m_user");
            int goodId=rs.getInt("m_good");

            User u = new User();
            u.setId(userId);
            m.setUser(u);

            Good g =new Good();

            g.setGood_id(goodId);
            m.setGood(g);



        } catch ( SQLException e ) {
            e.printStackTrace();
        }

        return m ;
    }

}
