package bean;

import java.io.Serializable;

import bean.User;

/**
 * 教师类
 */
public class Teacher extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int ru=2;
	private String auth = "";
	public int getRu() {
		return ru;
	}

	public void setRu(int ru) {
		this.ru = ru;
	}
	public String getauth() {
		return auth;
	}

	public void setauth(String auth) {
		this.auth = auth;
	}
	public Teacher() {
		this.ru = 2;
	}
	
	
	
	
	/**
	 * @param id 教师工号
	 * @param pwd 教师密码
	 * @param name 教师姓名
	 * @param telephone 教师电话
	 * @param ru 管理员权限3，教师权限2，学生1
	 * @param auth 老师授权码
	 */
	public Teacher(String Userid, String pwd, String name, String telephone,String auth) {
		super();
		this.Userid = Userid;
		this.pwd = pwd;
		this.name = name;
		this.telephone = telephone;
		this.ru = 2;
		this.auth = auth;
	}

	
	
}