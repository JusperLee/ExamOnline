package bean;

import java.io.Serializable;

/**
 * ���⼯��
 */
public class Mistakes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String Userid;
	private int questiontype;
	private String questionpoint;
	private int questionid;
	
	
	public Mistakes() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
	/**
	 * @param username ѧ���û���
	 * @param questiontype ��Ŀ���ͣ�ѡ���⡢����⡢�����, ����⣬�ж��⣩
	 * @param questionid ����ID
	 */
	public Mistakes(String Userid, int questiontype, String questionpoint,int questionid) {
		super();
		this.Userid = Userid;
		this.questiontype = questiontype;
		this.questionid = questionid;
		this.questionpoint = questionpoint;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Userid;
	}
	public void setUsername(String username) {
		this.Userid = Userid;
	}
	public int getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(int questiontype) {
		this.questiontype = questiontype;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getQuestionpoint() {
		return questionpoint;
	}
	public void setQuestionpoint(String questionpoint) {
		this.questionpoint = questionpoint;
	}
	
	
}
