package bean;


import java.io.Serializable;

/**
 * ����Ա��
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
	 * @param id ����Ա�˺�
	 * @param pwd ����Ա����
	 * @param name ����Ա����
	 * @param telephone ����Ա�绰
	 * @param ru ����ԱȨ��3����ʦȨ��2��ѧ��1
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
