package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Delicacies;

public interface DelicaciesDao {

	/**获取美食列表*/
	public List<Delicacies> getDelicacies();
	
	/**获取美食详情*/
	public Delicacies getDelicaciesDetail(int id);
}
