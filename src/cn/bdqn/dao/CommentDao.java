package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Comment;

public interface CommentDao {

	/**��ȡ��������*/
	public List<Comment> getComments(int type,int tid, int startPos, int pageLength);
	/**��������*/
	public boolean insertCom(Comment rec);
}
