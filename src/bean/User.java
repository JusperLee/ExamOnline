package bean;
import java.io.Serializable;

public abstract class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	protected  String Userid;
	protected  String pwd;
	protected  String name;
	protected  String studentclass;
	protected  String telephone;
	
	//默认权限为1，学生权限
	protected int ru = 1;
	
	
	
	public String getId() {
		return Userid;
	}
	public void setId(String Userid) {
		this.Userid = Userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getRu() {
		return ru;
	}
	public void setRu(int ru) {
		this.ru = ru;
	}
	
	
}
