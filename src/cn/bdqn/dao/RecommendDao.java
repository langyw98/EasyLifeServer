package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Recommend;

public interface RecommendDao {

	/**��ȡ��������*/
	public List<Recommend> getRecommends(int type,int tid);
	/**��������*/
	public boolean insertRec(Recommend rec);
}
