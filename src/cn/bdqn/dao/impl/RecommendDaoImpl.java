package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.RecommendDao;
import cn.bdqn.domain.Recommend;
import cn.bdqn.util.DBUtil;
/**ÆÀÂÛ*/
public class RecommendDaoImpl implements RecommendDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Recommend> getRecommends(int type,int tid) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select username,time,content,type,tid from recommend where type="+type+" and tid="+tid);
			List<Recommend> recs = new ArrayList<Recommend>();
			while(rs.next()){
				Recommend rec = new Recommend();
				rec.setUsername(rs.getString(1));
				rec.setTime(rs.getString(2));
				rec.setContent(rs.getString(3));
				rec.setType(rs.getInt(4));
				rec.setTid(rs.getInt(5));
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
	public boolean insertRec(Recommend rec) {
		try{
		conn = DBUtil.getConnection();
		st = conn.createStatement();
		int rownum = st.executeUpdate("insert into recommend(username,time,content,type,tid) values('"+rec.getUsername()+"','"+rec.getTime()+"','"+rec.getContent()+"','"+rec.getType()+"','"+rec.getTid()+"')");
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
