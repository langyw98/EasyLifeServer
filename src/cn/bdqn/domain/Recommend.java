package cn.bdqn.domain;

/**����*/
public class Recommend {

	private int recid;
	private String username;
	private String time;
	private String content;
	private int type; //���ͣ�1Ϊ��Ӱ 2Ϊ�ݳ���  3Ϊ��ʳ 4Ϊչ�� 5Ϊ���ֻ� 6Ϊ�������ŵ�Ӱ 
	private int tid;  //��ĳ��id��XX������
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getRecid() {
		return recid;
	}
	public void setRecid(int recid) {
		this.recid = recid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
