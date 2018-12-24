package bean;

import java.io.Serializable;

import bean.User;

/**
 * ѧ����
 */
public class Student extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String studentclass;
	private int ru=3;
	
	public Student(String Userid, String psd, String realname, String studentclass) {
		this.Userid = Userid;
		this.pwd = psd;
		this.name = realname;
		this.studentclass = studentclass;
		this.ru = 1;
	}
		

	@Override
	public String toString() {
		return "Student [study_id=" + Userid + ", pwd=" + pwd + ", name=" + name 
				+ ", studentclass=" + studentclass + ", telephone=" + telephone + ", ru=" + ru
				+ "]";
	}


	/**
	 * @param Userid ѧ��ѧ��
	 * @param pwd ѧ������
	 * @param name ѧ������
	 * @param studentclass ѧ�����ڰ༶
	 * @param telephone ѧ���绰
	 * @param ru ����ԱȨ��3����ʦȨ��2��ѧ��1
	 */
	public Student(String Userid, String pwd, String name, String studentclass, String telephone) {
		super();
		this.Userid = Userid;
		this.pwd = pwd;
		this.name = name;
		this.studentclass = studentclass;
		this.telephone = telephone;
		this.ru = 1;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}



	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	

}
