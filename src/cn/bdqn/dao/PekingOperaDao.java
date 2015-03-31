package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.PekingOpera;

public interface PekingOperaDao {

	/**获取京剧列表*/
	public List<PekingOpera> getPekingOperas();
	/**获取京剧详情*/
	public PekingOpera getPekingOperaDetail(int pid);
}
