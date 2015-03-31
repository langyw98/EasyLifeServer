package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.ConcertDao;
import cn.bdqn.domain.Concert;
import cn.bdqn.util.DBUtil;

/**ÑÝ³ª»á*/
public class ConcertDaoImpl implements ConcertDao{

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Concert> getConcert() {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select concert_id,name,time,image,address from concert");
			List<Concert> cons = new ArrayList<Concert>();
			while(rs.next()){
				Concert con = new Concert();
				con.setConcert_id(rs.getInt(1));
				con.setName( rs.getString(2));
				con.setTim(rs.getString(3));
				con.setImage(rs.getString(4));
				con.setAddress(rs.getString(5));
				cons.add(con);
			}
			return cons;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

	@Override
	public Concert getCondertDetails(int id) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select calls,mapx,mapy,price,descr from concert where concert_id="+id);
			Concert con = new Concert();
			while(rs.next()){
				con.setCall(rs.getString(1));
				con.setMapx(rs.getString(2));
				con.setMapy(rs.getString(3));
				con.setPrice(rs.getString(4));
				con.setDecs(rs.getString(5));
			}
			return con;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}
}
