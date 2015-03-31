package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Movie;

public interface MovieDao {

	/**获取电影列表*/
	public List<Movie> getMovie();
	
	/**获取电影详情*/
	public Movie getMovieDetails(int id);
}
