package cn.bdqn.dao;

import cn.bdqn.domain.User;

public interface UserDao {

	/**添加用户*/
	public boolean insertUser(User user);
	/**用户登录*/
	public boolean getUser(String uid);
	/**检验用户名是否已存在*/
	public boolean isExist(String strAccount);
	
	public String getNickName(String uid);
	
	public boolean updateNickName(String uid, String nickName);
	
	public boolean updatePwd(String uid, String oldpwd, String newpwd);
	
	public boolean updateNickname(String uid, String nickname);
}
