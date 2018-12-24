package bean;

import java.io.Serializable;


/**
 * �������
 */
public class Jdt implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private int id;	
	private String question;
	private int questiontype;
	private String questionpoint;
	
	public Jdt() {
		// TODO �Զ����ɵĹ��캯�����
		this.questiontype = 4;
	}
	
	
	
    /**
	 * @param question ����������
	 * @param questiontype  ��Ŀ���ͣ�����⣩
	 * @param questionpoint  ��Ŀ֪ʶ��
	 */
	public Jdt(String question, String questionpoint) {
		super();
		this.question = question;
		this.questiontype = 4;
		this.questionpoint = questionpoint;
	}



	@Override
	public String toString() {
		return "Jdt [id=" + id + ", question=" + question + ", questiontype=" + questiontype
				+ ", questionpoint=" + questionpoint + "]";
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(int questiontype) {
		this.questiontype = questiontype;
	}
	public String getQuestionpoint() {
		return questionpoint;
	}
	public void setQuestionpoint(String questionpoint) {
		this.questionpoint = questionpoint;
	}
}
