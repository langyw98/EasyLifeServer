package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Concert;

public interface ConcertDao {

	/**��ȡconcert�б�����*/
	public List<Concert> getConcert();
	/**��ȡconcert����*/
	public Concert getCondertDetails(int id);
}
