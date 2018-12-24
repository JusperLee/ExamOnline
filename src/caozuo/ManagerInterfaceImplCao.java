package caozuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Manager;
import bean.Teacher;
import caozuo.ManagerInterfaceCao;
import db.DBUtil;

public class ManagerInterfaceImplCao implements ManagerInterfaceCao {
	@SuppressWarnings("unused")//对警告忽视
	private static Connection con = DBUtil.getConnection();
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	boolean b=false;
	/**
	 * 查询所有教师，此处可做分页
	 */
	@Override
	public List<Teacher> select(Connection con) throws SQLException {
		Teacher info = null;
		List<Teacher> list  = new ArrayList<Teacher>();	
		String sql = "select tea_name,tea_pre,AES_DECRYPT(tea_auth,'dimtim'),"
				+ "AES_DECRYPT(tea_tel,'dimtim'),AES_DECRYPT(tea_password,'dimtim'),AES_DECRYPT(tea_num,'dimtim') from teacher_info ";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			info = new Teacher();
			info.setName(rs.getString(1));
			info.setId(rs.getString(6));
			info.setTelephone(rs.getString(4));
			info.setRu(2);
			info.setPwd(rs.getString(5));
			info.setauth(rs.getString(3));
			list.add(info);
		}
		DBUtil.CloseConnection(rs, pst, con);
		return list;
	}

	/**
	 * 添加教师
	 */
	@Override
	public boolean insert(Teacher t, Connection con) throws SQLException {
		String sql = "insert into teacher_info values (?,2,AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'))";
		pst=con.prepareStatement(sql);
		pst.setString(1, t.getName());
		pst.setString(2, t.getauth());
		pst.setString(3, t.getTelephone());
		pst.setString(4, t.getPwd());
		pst.setString(5, t.getId());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}


	
	/**
	 * 查询管理员个人信息
	 */
	@Override
	public Manager select(Manager m, Connection con) throws SQLException {
		Manager info=null;
		String sql = "select admin_name,AES_DECRYPT(admin_num,'dimtim'),AES_DECRYPT(admin_tel,'dimtim'),"
				+ "admin_pre,AES_DECRYPT(admin_password,'dimtim') from admin_info where admin_num = AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, m.getId());
		rs = pst.executeQuery();
		if(rs.next()) {
		    info = new Manager();
			info.setName(rs.getString(1));
			info.setPwd(rs.getString(5));
			info.setTelephone(rs.getString(3));
			info.setId(rs.getString(2));
			info.setRu(3);
		}
		DBUtil.CloseConnection(rs, pst, con);
		return info;
	}

	@Override
	public Manager showManagerInfo(String Userid) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		
		Manager u=null;
		String sql = "select admin_name,AES_DECRYPT(admin_num,'dimtim'),AES_DECRYPT(admin_tel,'dimtim'),"
				+ "admin_pre,AES_DECRYPT(admin_password,'dimtim') from admin_info where admin_num = AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, Userid);
		rs = pst.executeQuery();
		while (rs.next()) {
			 u=new Manager();
			u.setId(rs.getString(2));
			u.setPwd(rs.getString(5));
			u.setName(rs.getString(1));
            u.setTelephone(rs.getString(3));
			System.out.println(u.toString());

		}
		return u;
	}

	@Override
	public Manager login(String Userid, String pwd,String tel) throws SQLException {
		Connection con = DBUtil.getConnection();
		Manager info=null;
		String sql = "select admin_name,AES_DECRYPT(admin_num,'dimtim'),AES_DECRYPT(admin_tel,'dimtim')," + 
				"admin_pre,AES_DECRYPT(admin_password,'dimtim') from admin_info "
				+ "where admin_num = AES_ENCRYPT(?,'dimtim') and admin_password=AES_ENCRYPT(?,'dimtim') and admin_tel=AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, Userid);
		pst.setString(2,pwd);
		pst.setString(3, tel);
		rs = pst.executeQuery();
		if(rs.next()) {
			info=new Manager();
			info.setId(rs.getString(2));
			info.setPwd(rs.getString(5));
			info.setName(rs.getString(1));
			info.setTelephone(rs.getString(3));
		}
		DBUtil.CloseConnection(rs, pst, con);
		return info;
	}
	/**
	 * 删除教师
	 */
	@Override
	public boolean delete(String Userid, Connection con) throws SQLException {
		// TODO Auto-generated method stub
				PreparedStatement pst=null;
				boolean b = false;
				String sql = "delete from teacher_info  where tea_num = AES_ENCRYPT(?,'dimtim')";
				pst = con.prepareStatement(sql);
				pst.setString(1, Userid);
				int n = pst.executeUpdate();
				if(n>0) {
					b = true;
				}
				DBUtil.CloseConnection(rs, pst, con);
				return b;
	}
	/*
	 * 找回密码
	 * 
	 */
	public boolean find(Manager m,Connection con)throws SQLException{
		PreparedStatement pst=null;
		boolean b = false;
		String sql = "updata admin_info set admin_password = AES_ENCRYPT(?,'dimtim') where admin_num = AES_ENCRYPT(?,'dimtim') and admin_tel=AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, m.getPwd());
		pst.setString(2, m.getId());
		pst.setString(3, m.getTelephone());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}
}
