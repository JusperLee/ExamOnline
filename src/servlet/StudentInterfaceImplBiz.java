package servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Student;
import bean.StudentGrade;
import caozuo.StudentInterfaceCao;
import caozuo.StudentInterfaceImplCao;
import db.DBUtil;
import servlet.StudentInterfaceBiz;


public class StudentInterfaceImplBiz implements StudentInterfaceBiz{
	Connection con=DBUtil.getConnection();
	StudentInterfaceCao stu=new StudentInterfaceImplCao();
	@Override
	public Student select(Student s) throws SQLException {
		return stu.select(s, con);
	}
    @Override
    public List<Student> selectall() throws SQLException{
    	return stu.selectall(con);
    }
	@Override
	public boolean insert(Student s) throws SQLException {
		return stu.insert(s, con);
	}

	@Override
	public boolean updata(Student s) throws SQLException {
		return stu.updata(s, con);
	}
	
	public boolean updata_manager(Student s) throws SQLException{
		return stu.updata_manager(s, con);
	}

	@Override
	public boolean delete(String id) throws SQLException {
		return stu.delete(id, con);
	}

	@Override
	public Student showuserinfo(String username) throws SQLException {
		return stu.showuserinfo(username);
	}

	@Override
	public List<StudentGrade> stucj(String username) throws SQLException {
		return stu.stucj(username);
	}

	@Override
	public Student login(String username, String password,String tel) throws SQLException {
		
		return stu.login(username, password,tel);
	}

}

