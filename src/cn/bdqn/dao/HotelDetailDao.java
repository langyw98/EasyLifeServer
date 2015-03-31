package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.HotelDetail;

public interface HotelDetailDao {

	/**获取饭店的特色菜*/
	public List<HotelDetail> getHotelDetail(int delicId);
	
}
