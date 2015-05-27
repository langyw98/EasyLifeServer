package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.domain.Favor;

public interface FavorDao {
	public List<Favor> getFavorList(String uid);
	public boolean addFavor(String uid, int type, int tid);
	public boolean removeFavor(String uid, int type, int tid);
}
