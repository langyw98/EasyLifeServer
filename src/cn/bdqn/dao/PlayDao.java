package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Play;

public interface PlayDao {

	/**��ȡ�����б�*/
	public List<Play> getPlays();
	/**��ȡ��������*/
	public Play getPlayDetail(int pid);
}
