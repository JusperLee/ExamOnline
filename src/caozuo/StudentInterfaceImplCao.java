/*
 * @author likai
 */
package caozuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.StudentGrade;
import caozuo.StudentInterfaceCao;
import db.DBUtil;

public class StudentInterfaceImplCao implements StudentInterfaceCao{
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	boolean b=false;
	@Override
	/**
	 *查询学生信息
	 */
	public Student select(Student s,Connection con) throws SQLException {
		Student info=new Student();
		String sql = "select AES_DECRYPT(stu_name,'dimtim'),AES_DECRYPT(stu_class,'dimtim'),AES_DECRYPT(stu_number,'dimtim')" + 
				",AES_DECRYPT(stu_tel,'dimtim'),AES_DECRYPT(stu_password,'dimtim') from student_info where stu_number = AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, s.getId());
		rs = pst.executeQuery();
		if(rs.next()) {
			info.setId(rs.getString(3));
			info.setPwd(rs.getString(5));
			info.setName(rs.getString(1));
			System.out.println(rs.getString(1));
			info.setStudentclass(rs.getString(2));
			info.setTelephone(rs.getString(4));
		}
		DBUtil.CloseConnection(rs, pst, con);
		return info;
	}
    @Override
    /**
     * 将所有学生信息放到session
     */
    public List<Student> selectall(Connection con)throws SQLException{
    	List<Student> stu1=new ArrayList();
    	String sql = "select stu_name,AES_DECRYPT(stu_class,'dimtim'),AES_DECRYPT(stu_number,'dimtim')" + 
				",AES_DECRYPT(stu_tel,'dimtim'),AES_DECRYPT(stu_password,'dimtim') from student_info";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			Student stu = new Student();
			stu.setId(rs.getString(3));
			stu.setPwd(rs.getString(5));
			stu.setName(rs.getString(1));
			stu.setStudentclass(rs.getString(2));
			stu.setTelephone(rs.getString(4));
		    stu1.add(stu);
		}
		DBUtil.CloseConnection(rs, pst, con);
		return stu1;
    }
	@Override
	/**
	 * 增加学生
	 */
	public boolean insert(Student s, Connection con) throws SQLException {
		String sql = "insert into student_info values (?,AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'),1,AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'))";
		pst=con.prepareStatement(sql);
		pst.setString(1, s.getName());
		pst.setString(2, s.getStudentclass());
		pst.setString(3, s.getId());
		pst.setString(4, s.getTelephone());
		pst.setString(5,s.getPwd());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}

	@Override
	/**
	 * 修改学生信息
	 */
	public boolean updata(Student s, Connection con) throws SQLException {
		String sql = "update student_info set stu_class=AES_ENCRYPT(?,'dimtim'),stu_tel=AES_ENCRYPT(?,'dimtim'),stu_password = AES_ENCRYPT(?,'dimtim') where stu_number = AES_ENCRYPT(?,'dimtim')";
		pst=con.prepareStatement(sql);
		pst.setString(1, s.getStudentclass());
		pst.setString(2, s.getTelephone());
		pst.setString(3, s.getPwd());
		pst.setString(4, s.getId());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}
	@Override
	/**
	 * 修改学生信息
	 */
	public boolean find(Student s, Connection con) throws SQLException {
		String sql = "update student_info set stu_password=AES_ENCRYPT(?,'dimtim') where stu_number = AES_ENCRYPT(?,'dimtim') and stu_tel=AES_ENCRYPT(?,'dimtim')";
		pst=con.prepareStatement(sql);
		pst.setString(1, s.getStudentclass());
		pst.setString(2, s.getId());
		pst.setString(3, s.getTelephone());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}
	/**
	 * 
	 * @author likai
	 * @param 管理员修改信息
	 */
	public boolean updata_manager(Student s, Connection con) throws SQLException {
		String sql = "update student_info set stu_class=AES_ENCRYPT(?,'dimtim'),stu_tel=AES_ENCRYPT(?,'dimtim'),stu_password = AES_ENCRYPT(?,'dimtim'),stu_name=? where stu_number = AES_ENCRYPT(?,'dimtim')";
		pst=con.prepareStatement(sql);
		pst.setString(1, s.getStudentclass());
		pst.setString(2, s.getTelephone());
		pst.setString(3, s.getPwd());
		pst.setString(4, s.getName());
		pst.setString(5, s.getId());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}
	@Override
	/**
	 * 删除学生
	 */
	public boolean delete(String id, Connection con) throws SQLException {
		String sql = "delete from student_info  where stu_number = AES_ENCRYPT(?,'dimtim')";
		pst=con.prepareStatement(sql);
		pst.setString(1, id);
		int n = pst.executeUpdate();
		boolean b = false;
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}

	@Override
	public Student login(String Userid, String pwd,String tel) throws SQLException {
		Connection con = DBUtil.getConnection();
		Student info=null;
		String sql = "select stu_name,AES_DECRYPT(stu_class,'dimtim'),AES_DECRYPT(stu_number,'dimtim')"
				+ ",AES_DECRYPT(stu_tel,'dimtim'),AES_DECRYPT(stu_password,'dimtim') from student_info where stu_number = AES_ENCRYPT(?,'dimtim') and stu_password=AES_ENCRYPT(?,'dimtim') and stu_tel=AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, Userid);
		pst.setString(2,pwd);
		pst.setString(3, tel);
		rs = pst.executeQuery();
		if(rs.next()) {
			info=new Student();
			info.setId(rs.getString(3));
			info.setPwd(rs.getString(5));
			info.setName(rs.getString(1));
			info.setStudentclass(rs.getString(2));
			info.setTelephone(rs.getString(4));
		}
		System.out.println(info);
		DBUtil.CloseConnection(rs, pst, con);
		return info;
	}

	@Override
	public Student showuserinfo(String Userid) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		
		
		String sql =  "select stu_name,AES_DECRYPT(stu_class,'dimtim'),AES_DECRYPT(stu_number,'dimtim')"
				+ ",AES_DECRYPT(stu_tel,'dimtim'),AES_DECRYPT(stu_password,'dimtim') from student_info where stu_number = AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, Userid);
		rs = pst.executeQuery();
		Student u=null;
		while (rs.next()) {
			u=new Student();
			u.setId(Userid);
			u.setName(rs.getString(1));
            u.setTelephone(rs.getString(3));
            u.setStudentclass(rs.getString(2));
            u.setPwd(rs.getString(4));
			System.out.println(u.toString());

		}
		System.out.println(u);
		return u;
	}

	@Override
	public List<StudentGrade> stucj(String Useid) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		ArrayList<StudentGrade> list = new ArrayList<StudentGrade>();
		try {
			String sql="select * from studentgrade where stu_number=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, Useid);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentGrade sg=new StudentGrade();
				sg.setUserId(rs.getString(1));
				sg.setName(rs.getString(2));
				sg.setXztscore(rs.getInt(3));
				sg.setTktscore(rs.getInt(4));
				sg.setBctscore(rs.getInt(5));
				sg.setJdtscore(rs.getInt(6));
				sg.setPdtscore(rs.getInt(7));
				sg.setscore(rs.getInt(8));
				sg.setPapername(rs.getString(9));
				sg.setPaperId(rs.getInt(10));
				list.add(sg);
				System.out.println(sg.getUserId());
	}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBUtil.CloseConnection(rs, pst, con);
	}
		return list;


}}
