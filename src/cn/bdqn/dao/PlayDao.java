package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Play;

public interface PlayDao {

	/**获取话剧列表*/
	public List<Play> getPlays();
	/**获取话剧详情*/
	public Play getPlayDetail(int pid);
}
