package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Movie;

public interface MovieDao {

	/**��ȡ��Ӱ�б�*/
	public List<Movie> getMovie(int startPos);
	
	/**��ȡ��Ӱ����*/
	public Movie getMovieDetails(int id);
}
