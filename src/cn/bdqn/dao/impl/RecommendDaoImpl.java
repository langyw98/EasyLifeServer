package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.RecommendDao;
import cn.bdqn.domain.Comment;
import cn.bdqn.domain.Recommend;
import cn.bdqn.util.DBUtil;

public class RecommendDaoImpl implements RecommendDao {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Recommend> getRecommendList() {
		// TODO Auto-generated method stub
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();

			rs = st.executeQuery("SELECT type,tid FROM recommend");
			List<Recommend> recs = new ArrayList<Recommend>();
			while(rs.next()){
				Recommend rec = new Recommend();
				rec.setType(rs.getInt(1));
				rec.setTid(rs.getInt(2));
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

}
