package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Delicacies;

public interface DelicaciesDao {

	/**��ȡ��ʳ�б�*/
	public List<Delicacies> getDelicacies();
	
	/**��ȡ��ʳ����*/
	public Delicacies getDelicaciesDetail(int id);
}
