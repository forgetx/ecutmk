/*package com.ecutmk.dao;


import com.ecutmk.entity.Reply;
import com.ecutmk.helper.JdbcHelper;

public class ReplyDao {
    public boolean save(Reply reply)
    {
        JdbcHelper h=JdbcHelper.getInstance();
        String sql="insert into reply(r_id,r_user,r_m_id,r_m_user,r_good,r_date,r_content) values(?,?,?,?,?,?,?)";
        int count=h.update(sql,reply.getR_id(),reply.getR_user().getUsername(),reply.getR_m_id(),reply.getR_m_user().getUsername(), reply.getR_good().getGood_id(),reply.getR_date(),reply.getR_content());
        h.release();
        return count==1;
    }
    public Reply find(int r_id)
    {
        Reply r=new Reply();

        return r;
    }
}
*/