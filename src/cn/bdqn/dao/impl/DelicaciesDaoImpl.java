package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.DelicaciesDao;
import cn.bdqn.domain.Delicacies;
import cn.bdqn.util.DBUtil;
/**√¿ ≥*/
public class DelicaciesDaoImpl implements DelicaciesDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Delicacies> getDelicacies() {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select delicacies_id,label,address,avgs,image,name from delicacies");
			List<Delicacies> dels = new ArrayList<Delicacies>();
			while(rs.next()){
				Delicacies del = new Delicacies();
				del.setDelicacies_id(rs.getInt(1));
				del.setLabel(rs.getString(2));
				del.setAddress(rs.getString(3));
				del.setAvg(rs.getInt(4));
				del.setImagename(rs.getString(5));
				del.setName(rs.getString(6));
				dels.add(del);
			}
			return dels;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

	@Override
	public Delicacies getDelicaciesDetail(int id) {
		
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select calls,mapx,mapy from delicacies where delicacies_id="+id);
			Delicacies del = new Delicacies();
			while(rs.next()){
				del.setCall(rs.getString(1));
				del.setMapx(rs.getString(2));
				del.setMapy(rs.getString(3));
			}
			return del;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}
}
