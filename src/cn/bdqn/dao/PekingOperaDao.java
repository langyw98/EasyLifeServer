package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.PekingOpera;

public interface PekingOperaDao {

	/**��ȡ�����б�*/
	public List<PekingOpera> getPekingOperas();
	/**��ȡ��������*/
	public PekingOpera getPekingOperaDetail(int pid);
}
