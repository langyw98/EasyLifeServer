package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.PekingOperaDao;
import cn.bdqn.domain.PekingOpera;
import cn.bdqn.util.DBUtil;
/**¾©¾ç*/
public class PekingOperaDaoImpl implements PekingOperaDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<PekingOpera> getPekingOperas() {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select pekingopera_id,name,time,image,address from pekingopera");
			List<PekingOpera> peos = new ArrayList<PekingOpera>();
			while(rs.next()){
				PekingOpera peo = new PekingOpera();
				peo.setPekingopera_id(rs.getInt(1));
				peo.setName( rs.getString(2));
				peo.setTime(rs.getString(3));
				peo.setImage(rs.getString(4));
				peo.setAddress(rs.getString(5));
				peos.add(peo);
			}
			return peos;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

	@Override
	public PekingOpera getPekingOperaDetail(int pid) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select calls,mapx,mapy,price,descr from pekingopera where pekingopera_id="+pid);
			PekingOpera peo = new PekingOpera();
			while(rs.next()){
				peo.setCall(rs.getString(1));
				peo.setMapx(rs.getString(2));
				peo.setMapy(rs.getString(3));
				peo.setPrice(rs.getString(4));
				peo.setDecs(rs.getString(5));
			}
			return peo;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

}
