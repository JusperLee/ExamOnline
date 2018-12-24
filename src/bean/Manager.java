package bean;


import java.io.Serializable;

/**
 * 管理员类
 */
public class Manager extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int ru=3;
	
	public int getRu() {
		return ru;
	}

	public void setRu(int ru) {
		this.ru = ru;
	}


	
	public Manager() {
		this.ru = 3;
	}
	
	
	/**
	 * @param id 管理员账号
	 * @param pwd 管理员密码
	 * @param name 管理员姓名
	 * @param telephone 管理员电话
	 * @param ru 管理员权限3，教师权限2，学生1
	 */
	public Manager(String Userid, String pwd, String name, String telephone) {
		super();
		this.Userid = Userid;
		this.pwd = pwd;
		this.name = name;
		this.telephone = telephone;
		this.ru = 1;
	}
	
	
	
}
