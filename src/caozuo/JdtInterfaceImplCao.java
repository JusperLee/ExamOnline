package caozuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Jdt;
import caozuo.JdtInterfaceCao;
import db.DBUtil;
	
public class JdtInterfaceImplCao implements JdtInterfaceCao {
	private static Connection con = null;
	private static PreparedStatement pr = null;
	private static ResultSet rs = null;

	@Override
	public boolean insert(Jdt jdt) {
		int row=0;
         con=DBUtil.getConnection();
         String sql="insert into jdt values (null,?,?,?)";
         try {
			pr=con.prepareStatement(sql);
			pr.setString(1, jdt.getQuestion());
			pr.setInt(2, jdt.getQuestiontype());
			pr.setString(3, jdt.getQuestionpoint());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
	
		
		return row>0;
	}

	@Override
	public boolean delete(Jdt jdt) {
		int row=0;
        con=DBUtil.getConnection();
        String sql="delete from jdt where id=?";
        try {
			pr=con.prepareStatement(sql);
			pr.setInt(1, jdt.getId());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}
/**
 * 只能修改已有的对象，不能传入新建的对象，因为没有ID值。
 */
	@Override
	public boolean update(Jdt jdt) {
		int row=0;
        con=DBUtil.getConnection();
        //题目种类不会变
        String sql="update jdt set question=? where id=?";
        try {
			pr=con.prepareStatement(sql);
			
			pr.setString(1, jdt.getQuestion());
			pr.setInt(2, jdt.getId());
			
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}

	@Override
	public List<Jdt> select() {
		List<Jdt> list=new ArrayList<Jdt>();
		String sql="select * from jdt";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			rs=pr.executeQuery();
			while (rs.next()) {
				Jdt jdt=new Jdt();
				jdt.setId(rs.getInt("id"));
				jdt.setQuestion(rs.getString("question"));
				jdt.setQuestiontype(3);
				jdt.setQuestionpoint(rs.getString("questionpoint"));
				list.add(jdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}

	public Jdt select(int id) {
		String sql="select * from jdt where id=?";
		  con=DBUtil.getConnection();
		  Jdt jdt=null;
		  try {
			pr=con.prepareStatement(sql);
			pr.setInt(1, id);
			rs=pr.executeQuery();
			while (rs.next()) {
				jdt=new Jdt();
				jdt.setId(rs.getInt("id"));
				jdt.setQuestion(rs.getString("question"));
				jdt.setQuestiontype(3);
				jdt.setQuestionpoint(rs.getString("questionpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return jdt;
	}
	
	@Override
	public List<Jdt> select(String questionpoint) {
		List<Jdt> list=new ArrayList<Jdt>();
		String sql="select * from jdt where questionpoint=?";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			pr.setString(1, questionpoint);
			rs=pr.executeQuery();
			while (rs.next()) {
				Jdt jdt=new Jdt();
				jdt.setId(rs.getInt("id"));
				jdt.setQuestion(rs.getString("question"));
				jdt.setQuestiontype(3);
				jdt.setQuestionpoint(rs.getString("questionpoint"));
				list.add(jdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}

}
