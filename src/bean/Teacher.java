package bean;

import java.io.Serializable;

import bean.User;

/**
 * ��ʦ��
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
	 * @param id ��ʦ����
	 * @param pwd ��ʦ����
	 * @param name ��ʦ����
	 * @param telephone ��ʦ�绰
	 * @param ru ����ԱȨ��3����ʦȨ��2��ѧ��1
	 * @param auth ��ʦ��Ȩ��
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