package bean;

import java.io.Serializable;


/**
 * �������
 */
public class Tkt implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private int id;	
	private String question;
	private String answer;
	private int questiontype;
	private String questionpoint;
	
	public Tkt() {
		// TODO �Զ����ɵĹ��캯�����
		this.questiontype = 2;
	}
	
	
	
    /**
	 * @param question ��������
	 * @param answer ������
	 * @param questiontype  ��Ŀ���ͣ�����⣩
	 * @param questionpoint  ��Ŀ֪ʶ��
	 */
	public Tkt(String question, String answer, String questionpoint) {
		super();
		this.question = question;
		this.answer = answer;
		this.questiontype = 2;
		this.questionpoint = questionpoint;
	}



	@Override
	public String toString() {
		return "Tkt [id=" + id + ", question=" + question + ", answer=" + answer + ", questiontype=" + questiontype
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
