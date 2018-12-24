package bean;

import java.io.Serializable;


/**
 * ѡ������
 */
public class Xzt implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String question;
	private String answer;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private int questiontype;
	private String questionpoint;
	
	public Xzt() {
		// TODO �Զ����ɵĹ��캯�����
		this.questiontype = 1;
	}
		
  /**
	 * @param question ѡ�������
	 * @param answer ѡ�����ѡ��
	 * @param optionA ѡ��A
	 * @param optionB ѡ��B
	 * @param optionC ѡ��C
	 * @param optionD ѡ��D
     * @param questiontype  ��Ŀ���ͣ�ѡ���⣩
	 * @param questionpoint  ��Ŀ֪ʶ��
	 */
	public Xzt(String question, String answer, String optionA, String optionB, String optionC, String optionD,
			 String questionpoint) {
		super();
		this.question = question;
		this.answer = answer;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.questiontype = 1;
		this.questionpoint = questionpoint;
	}




    @Override
public String toString() {
	return "Xzt [id=" + id + ", question=" + question + ", answer=" + answer + ", optionA=" + optionA + ", optionB="
			+ optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", questiontype=" + questiontype
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
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
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
