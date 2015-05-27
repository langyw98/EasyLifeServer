package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.CommentDao;
import cn.bdqn.domain.Comment;
import cn.bdqn.util.DBUtil;
/**ÆÀÂÛ*/
public class CommentDaoImpl implements CommentDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Comment> getComments(int type,int tid, int startPos, int pageLength) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			String selection = "";
			if(startPos != -1){
				selection = " AND recid < " + startPos;
			}
//			rs = st.executeQuery("select username,time,content,type,tid from recommend where type="+type+" and tid="+tid);
			String sql = "SELECT recid,username,time,content,type,tid FROM comment WHERE type = "+ type + " AND tid = " + tid + selection + " ORDER BY recid DESC LIMIT " + pageLength;
			rs = st.executeQuery("SELECT recid,username,time,content,type,tid FROM comment WHERE type = "+ type + " AND tid = " + tid + selection + " ORDER BY recid DESC LIMIT " + pageLength);
			List<Comment> recs = new ArrayList<Comment>();
			while(rs.next()){
				Comment rec = new Comment();
				rec.setRecid(rs.getInt(1));
				rec.setUsername(rs.getString(2));
				rec.setTime(rs.getString(3));
				rec.setContent(rs.getString(4));
				rec.setType(rs.getInt(5));
				rec.setTid(rs.getInt(6));
				recs.add(rec);
			}
			return recs;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

	@Override
	public boolean insertCom(Comment rec) {
		try{
		conn = DBUtil.getConnection();
		st = conn.createStatement();
		int rownum = st.executeUpdate("insert into comment(username,time,content,type,tid) values('"+rec.getUsername()+"','"+rec.getTime()+"','"+rec.getContent()+"','"+rec.getType()+"','"+rec.getTid()+"')");
		if(rownum > 0){
			return true;
		}else{
			return false;
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return false;
	}

}
