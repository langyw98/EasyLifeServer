package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.DisplayDao;
import cn.bdqn.domain.Display;
import cn.bdqn.util.DBUtil;

/** ’π¿¿ */
public class DisplayDaoImpl implements DisplayDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public List<Display> getDisplays() {
		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select displayid,name,time,address,image from display");
			List<Display> disps = new ArrayList<Display>();
			while (rs.next()) {
				Display dis = new Display();
				dis.setDisplayid(rs.getInt(1));
				dis.setName(rs.getString(2));
				dis.setTime(rs.getString(3));
				dis.setAddress(rs.getString(4));
				dis.setImagename(rs.getString(5));
				disps.add(dis);
			}
			return disps;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

	@Override
	public Display getDisplayDetail(int id) {
		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select host,calls,descr from display where displayid="+id);
			Display dis = new Display();
			while (rs.next()) {
				dis.setHost(rs.getString(1));
				dis.setCall(rs.getString(2));
				dis.setDesc(rs.getString(3));
			}
			return dis;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

}
