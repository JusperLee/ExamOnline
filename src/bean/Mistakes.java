package bean;

import java.io.Serializable;

/**
 * 错题集类
 */
public class Mistakes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String Userid;
	private int questiontype;
	private String questionpoint;
	private int questionid;
	
	
	public Mistakes() {
		// TODO 自动生成的构造函数存根
	}
	
	
	/**
	 * @param username 学生用户名
	 * @param questiontype 题目类型（选择题、填空题、编程题, 简答题，判断题）
	 * @param questionid 问题ID
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
