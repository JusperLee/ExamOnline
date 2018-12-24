package caozuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Mistakes;

import caozuo.MistakesInterfaceCao;
import db.DBUtil;
/*
 *  @author likai
 */
public class MistakeInterfaceImplCao implements MistakesInterfaceCao{
	private static Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	boolean b=false;
	@Override
	public boolean insert(Mistakes mistakes) {
		con=DBUtil.getConnection();
        String sql="insert into  mistakes values (null,?,?,?,?)";
        try {
			pst=con.prepareStatement(sql);			
        	pst.setString(1, mistakes.getUsername());
			pst.setInt(2, mistakes.getQuestiontype());
			pst.setString(3, mistakes.getQuestionpoint());
			pst.setInt(4, mistakes.getQuestionid());
			int n=pst.executeUpdate();		
			if(n>0) {
				b=true;
			}
        	} catch (SQLException e) {
				e.printStackTrace();
			}
        finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return b;
	}

	@Override
	public boolean delete(Mistakes mistakes) {
		con=DBUtil.getConnection();
		String sql = "delete from mistakes  where username = ? and questiontype=? and questionid=?";
		try {
		pst=con.prepareStatement(sql);
		pst.setString(1, mistakes.getUsername());
		pst.setInt(2, mistakes.getQuestiontype());
		pst.setInt(3, mistakes.getQuestionid());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return b;
	}

	@Override	
	public List<Mistakes> selectxzt(String username) {
		con=DBUtil.getConnection();
		
		List<Mistakes> list  = new ArrayList<Mistakes>();	
		String sql = "select * from mistakes where username= ? and questiontype = 1";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			while(rs.next()) {
				Mistakes mis=new Mistakes();
				mis.setId(rs.getInt(1));
				mis.setUsername(rs.getString(2));
				mis.setQuestiontype(rs.getInt(3));
				mis.setQuestionpoint(rs.getString(4));
				mis.setQuestionid(rs.getInt(5));
				list.add(mis);
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return list;
	}
	public static void main(String[] args) {
		//MistakesInterfaceBiz mif=new MistakesInterfaceImplBiz();		
		MistakesInterfaceCao md=new MistakeInterfaceImplCao();
		List<Mistakes> list=md.selectxzt("fang");
		for(Mistakes m:list)
		{
			System.out.println(m.getId()+","+m.getQuestionid());
		}
	}

	@Override
	public List<Mistakes> select(String username, String questionpoint) {
		con=DBUtil.getConnection();
		
		List<Mistakes> list  = new ArrayList<Mistakes>();	
		String sql = "select * from mistakes where username= ? and questionpoint=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, questionpoint);
			rs = pst.executeQuery();
			while(rs.next()) {
				Mistakes mis=new Mistakes();
				mis.setId(rs.getInt(1));
				mis.setUsername(rs.getString(2));
				mis.setQuestiontype(rs.getInt(3));
				mis.setQuestionpoint(rs.getString(4));
				mis.setQuestionid(rs.getInt(5));
				list.add(mis);
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return list;
	}



	@Override
	public List<Mistakes> selecttkt(String username) {
		con=DBUtil.getConnection();
	
		List<Mistakes> list  = new ArrayList<Mistakes>();	
		String sql = "select * from mistakes where username= ? and questiontype = 2";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			while(rs.next()) {
				Mistakes mis=new Mistakes();
				mis.setId(rs.getInt(1));
				mis.setUsername(rs.getString(2));
				mis.setQuestiontype(rs.getInt(3));
				mis.setQuestionpoint(rs.getString(4));
				mis.setQuestionid(rs.getInt(5));
				list.add(mis);
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return list;
	}
	
	public List<Mistakes> selectpdt(String username) {
		con=DBUtil.getConnection();
	
		List<Mistakes> list  = new ArrayList<Mistakes>();	
		String sql = "select * from mistakes where username= ? and questiontype = 5";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			while(rs.next()) {
				Mistakes mis=new Mistakes();
				mis.setId(rs.getInt(1));
				mis.setUsername(rs.getString(2));
				mis.setQuestiontype(rs.getInt(3));
				mis.setQuestionpoint(rs.getString(4));
				mis.setQuestionid(rs.getInt(5));
				list.add(mis);
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		System.out.println(list.size());
		return list;
	}
	
	public List<Mistakes> selectjdt(String username) {
		con=DBUtil.getConnection();
	
		List<Mistakes> list  = new ArrayList<Mistakes>();	
		String sql = "select * from Mistakes where username= ? and questiontype = 4";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			while(rs.next()) {
				Mistakes mis=new Mistakes();
				mis.setId(rs.getInt(1));
				mis.setUsername(rs.getString(2));
				mis.setQuestiontype(rs.getInt(3));
				mis.setQuestionpoint(rs.getString(4));
				mis.setQuestionid(rs.getInt(5));
				list.add(mis);
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return list;
	}
/**
 * �������⴫����������
 */
	@Override
	public List<Mistakes> selectbct(String username) {
		con=DBUtil.getConnection();
		
		List<Mistakes> list  = new ArrayList<Mistakes>();	
		String sql = "select * from Mistakes where username= ? and questiontype = 3";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			while(rs.next()) {
				Mistakes mis=new Mistakes();
				mis.setId(rs.getInt(1));
				mis.setUsername(rs.getString(2));
				mis.setQuestiontype(rs.getInt(3));
				mis.setQuestionpoint(rs.getString(4));
				mis.setQuestionid(rs.getInt(5));
				list.add(mis);
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return list;
	}

}
