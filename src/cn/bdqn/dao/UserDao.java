package cn.bdqn.dao;

import cn.bdqn.domain.User;

public interface UserDao {

	/**����û�*/
	public boolean insertUser(User user);
	/**�û���¼*/
	public boolean getUser(String uid);
	/**�����û����Ƿ��Ѵ���*/
	public boolean isExist(String strAccount);
}
