package cn.bdqn.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static String dbUrl = "jdbc:mysql://localhost:3306/life";
	private static String dbUser = "root";
	private static String dbPwd = "root";

	static {
		try {
			// ����MySQL���ݿ���������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		// ���һ�����ݿ�����
		return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
	}

	/** �ر����ݿ����� */
	public static void freeDB(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
