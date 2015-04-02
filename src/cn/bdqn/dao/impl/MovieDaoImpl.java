package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.MovieDao;
import cn.bdqn.domain.Movie;
import cn.bdqn.util.DBUtil;
/**µÁ”∞*/
public class MovieDaoImpl implements MovieDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public List<Movie> getMovie(int startPos) {
		try{
			List<Movie> movies = new ArrayList<Movie>();
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			String selection = "";
			if(startPos > 0){
				selection = "where movieid > " +startPos;
				rs = st.executeQuery("SELECT MAX(movieid) FROM movie");
				rs.next();
				int endPos = rs.getInt(1);
				if(endPos <= startPos){
					return movies;
				}else{
					rs.close();
				}
			}
			rs = st.executeQuery("select movieid,name,type,time,player,image,descr,timelong from movie" + selection);
			while(rs.next()){
				Movie movie = new Movie();
				movie.setMovieid(rs.getInt(1));
				movie.setName(rs.getString(2));
				movie.setType(rs.getString(3));
				movie.setTime(rs.getString(4));
				movie.setPlayer(rs.getString(5));
				movie.setImagename(rs.getString(6));
				movie.setDesc(rs.getString(7));
				movie.setTimelong(rs.getString(8));
				
				movies.add(movie);
			}
			return movies;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

	@Override
	public Movie getMovieDetails(int mid) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select descr,timelong from movie where movieid="+mid);
			Movie movie = new Movie();
			while(rs.next()){
				movie.setDesc(rs.getString(1));
				movie.setTimelong(rs.getString(2));
			}
			return movie;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return null;
	}

}
