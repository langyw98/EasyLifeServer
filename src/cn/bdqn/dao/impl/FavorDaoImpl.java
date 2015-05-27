package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.FavorDao;
import cn.bdqn.domain.Favor;
import cn.bdqn.util.DBUtil;

public class FavorDaoImpl implements FavorDao {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Favor> getFavorList(String uid) {
		// TODO Auto-generated method stub
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();

			rs = st.executeQuery("SELECT type,t_id FROM favor WHERE uid = '" + uid + "'");
			List<Favor> recs = new ArrayList<Favor>();
			while(rs.next()){
				Favor rec = new Favor();
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

	@Override
	public boolean addFavor(String uid, int type, int tid) {
		// TODO Auto-generated method stub
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT uid FROM favor WHERE type = '"
					+ type + "' AND t_id = '" + tid+ "' AND uid = '" + uid + "'");
			if(rs.next()){
				return true;
			}
			String sql = "INSERT INTO favor(type,t_id, uid) values('"+ type +"','"+ tid +"','"+ uid +"')";
			int rownum = st.executeUpdate("INSERT INTO favor(type,t_id, uid) values('"+ type +"','"+ tid +"','"+ uid +"')");
			if(rownum > 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return false;
	}

	@Override
	public boolean removeFavor(String uid, int type, int tid) {
		// TODO Auto-generated method stub
		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			String sql = "DELETE FROM favor WHERE type = '"
					+ type + "' AND t_id = '" + tid+ "' AND uid = '" + uid + "'";
			st.execute("DELETE FROM favor WHERE type = '"
					+ type + "' AND t_id = '" + tid+ "' AND uid = '" + uid + "'");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeDB(rs, st, conn);
		}
		return false;
	}

}
