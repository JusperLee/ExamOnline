package caozuo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Student;
import bean.StudentGrade;

public interface StudentInterfaceCao {
	public Student select(Student s,Connection con)throws SQLException;
	public boolean insert(Student s, Connection con)throws SQLException;
	public boolean updata(Student s,Connection con)throws SQLException;
	public boolean find(Student s,Connection con)throws SQLException;
	public boolean delete(String id,Connection con)throws SQLException;
	public Student login(String username, String pwd,String tel) throws SQLException;
	public Student showuserinfo(String username)throws SQLException;
	public List<StudentGrade> stucj(String username)throws SQLException; 
	public List<Student> selectall(Connection con)throws SQLException;
	public boolean updata_manager(Student s, Connection con) throws SQLException;
}
