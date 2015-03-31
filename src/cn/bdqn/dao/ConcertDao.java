package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Concert;

public interface ConcertDao {

	/**获取concert列表数据*/
	public List<Concert> getConcert();
	/**获取concert详情*/
	public Concert getCondertDetails(int id);
}
