package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.HotelDetail;

public interface HotelDetailDao {

	/**��ȡ�������ɫ��*/
	public List<HotelDetail> getHotelDetail(int delicId);
	
}
