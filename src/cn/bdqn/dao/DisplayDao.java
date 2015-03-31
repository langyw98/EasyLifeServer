package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Display;

public interface DisplayDao {

	/**获取展览列表*/
	public List<Display> getDisplays();
	/**获取展览详情*/
	public Display getDisplayDetail(int id);
}
