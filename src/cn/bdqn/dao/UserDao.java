package cn.bdqn.dao;

import cn.bdqn.domain.User;

public interface UserDao {

	/**����û�*/
	public boolean insertUser(User user);
	/**�û���¼*/
	public boolean getUser(String uid);
	/**�����û����Ƿ��Ѵ���*/
	public boolean isExist(String strAccount);
	
	public String getNickName(String uid);
	
	public boolean updateNickName(String uid, String nickName);
	
	public boolean updatePwd(String uid, String oldpwd, String newpwd);
	
	public boolean updateNickname(String uid, String nickname);
}
