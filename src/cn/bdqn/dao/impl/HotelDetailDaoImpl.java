package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.HotelDetailDao;
import cn.bdqn.domain.HotelDetail;
import cn.bdqn.util.DBUtil;
/**美食特色菜列表*/
public class HotelDetailDaoImpl implements HotelDetailDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<HotelDetail> getHotelDetail(int delicId) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select name,image,oldprice,newprice from hotedetail where fk_id="+delicId);
			List<HotelDetail> hotels = new ArrayList<HotelDetail>();
			while(rs.next()){
				HotelDetail hotel= new HotelDetail();
				hotel.setName(rs.getString(1));
				hotel.setImagename(rs.getString(2));
				hotel.setOldprice(rs.getInt(3));
				hotel.setNowproce(rs.getInt(4));
				hotels.add(hotel);
			}
			return hotels;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}
}
