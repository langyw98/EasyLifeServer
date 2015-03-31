package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Recommend;

public interface RecommendDao {

	/**获取所有评论*/
	public List<Recommend> getRecommends(int type,int tid);
	/**插入评论*/
	public boolean insertRec(Recommend rec);
}
