package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Comment;

public interface CommentDao {

	/**获取所有评论*/
	public List<Comment> getComments(int type,int tid, int startPos, int pageLength);
	/**插入评论*/
	public boolean insertCom(Comment rec);
}
