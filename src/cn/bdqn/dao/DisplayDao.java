package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Display;

public interface DisplayDao {

	/**��ȡչ���б�*/
	public List<Display> getDisplays();
	/**��ȡչ������*/
	public Display getDisplayDetail(int id);
}
