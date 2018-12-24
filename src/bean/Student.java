package bean;

import java.io.Serializable;

import bean.User;

/**
 * 学生类
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
	 * @param Userid 学生学号
	 * @param pwd 学生密码
	 * @param name 学生姓名
	 * @param studentclass 学生所在班级
	 * @param telephone 学生电话
	 * @param ru 管理员权限3，教师权限2，学生1
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
