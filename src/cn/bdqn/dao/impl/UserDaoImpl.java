package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import cn.bdqn.dao.UserDao;
import cn.bdqn.domain.User;
import cn.bdqn.util.DBUtil;
/**ÓÃ»§*/
public class UserDaoImpl implements UserDao {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public boolean insertUser(User user) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			int rownum = st.executeUpdate("insert into user(name,password,uid) values('"+user.getName()+"','"+user.getPassword()+"','"+user.getUid()+"')");
			if(rownum > 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return false;
	}

	@Override
	public boolean getUser(String uid) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from user where uid='"+uid+"'");
			if(rs.first()){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return false;
	}

	@Override
	public boolean isExist(String strAccount) {
		try{
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from user where name='"+strAccount+"'");
			if(rs.first()){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			
		}finally{
			DBUtil.freeDB(rs, st, conn);
		}
		return false;
	}

}
