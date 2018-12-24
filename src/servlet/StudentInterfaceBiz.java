package servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Student;
import bean.StudentGrade;

public interface StudentInterfaceBiz {
	public Student select(Student s)throws SQLException;
	public boolean insert(Student s)throws SQLException;
	public boolean updata(Student s)throws SQLException;
	public boolean delete(String id)throws SQLException;
	public Student login(String username,String password,String tel)throws SQLException;
	public Student showuserinfo(String username)throws SQLException;
	public List<StudentGrade> stucj(String username)throws SQLException; 
    public List<Student> selectall() throws SQLException;
    public boolean updata_manager(Student s) throws SQLException;
}
