package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.MusicDao;
import cn.bdqn.domain.Music;
import cn.bdqn.util.DBUtil;
/**“Ù¿÷ª·*/
public class MusicDaoImpl implements MusicDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Music> getMusics() {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select musicid,name,time,image,address from music");
			List<Music> musics = new ArrayList<Music>();
			while(rs.next()){
				Music music = new Music();
				music.setMusicid(rs.getInt(1));
				music.setName( rs.getString(2));
				music.setTime(rs.getString(3));
				music.setImagename(rs.getString(4));
				music.setAddress(rs.getString(5));
				musics.add(music);
			}
			return musics;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

	@Override
	public Music getMusicDetailDao(int mid) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select calls,mapx,mapy,price,descr from music where musicid="+mid);
			Music music = new Music();
			while(rs.next()){
				music.setCall(rs.getString(1));
				music.setMapx(rs.getString(2));
				music.setMapy(rs.getString(3));
				music.setPrice(rs.getString(4));
				music.setDecs(rs.getString(5));
			}
			return music;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

}
