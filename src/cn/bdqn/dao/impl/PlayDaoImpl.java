package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.PlayDao;
import cn.bdqn.domain.Play;
import cn.bdqn.util.DBUtil;
/**»°¾ç*/
public class PlayDaoImpl implements PlayDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Play> getPlays() {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select play_id,name,time,image,address from play");
			List<Play> plays = new ArrayList<Play>();
			while(rs.next()){
				Play play = new Play();
				play.setPlay_id(rs.getInt(1));
				play.setName( rs.getString(2));
				play.setTime(rs.getString(3));
				play.setImage(rs.getString(4));
				play.setAddress(rs.getString(5));
				plays.add(play);
			}
			return plays;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

	@Override
	public Play getPlayDetail(int pid) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select calls,mapx,mapy,price,descr from play where play_id="+pid);
			Play play = new Play();
			while(rs.next()){
				play.setCall(rs.getString(1));
				play.setMapx(rs.getString(2));
				play.setMapy(rs.getString(3));
				play.setPrice(rs.getString(4));
				play.setDecs(rs.getString(5));
			}
			return play;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

}
