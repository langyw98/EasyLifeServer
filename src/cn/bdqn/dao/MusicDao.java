package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Music;

public interface MusicDao {

	/**获取音乐列表*/
	public List<Music> getMusics();
	/**获取音乐详情*/
	public Music getMusicDetailDao(int mid);
}
