package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Music;

public interface MusicDao {

	/**��ȡ�����б�*/
	public List<Music> getMusics();
	/**��ȡ��������*/
	public Music getMusicDetailDao(int mid);
}
