package caozuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Pdt;
import caozuo.PdtInterfaceCao;
import db.DBUtil;

public class PdtInterfaceImplCao implements PdtInterfaceCao {
	private static Connection con = null;
	private static PreparedStatement pr = null;
	private static ResultSet rs = null;
	@Override
	public boolean insert(Pdt pdt) {
		int row=0;
        con=DBUtil.getConnection();
        String sql="insert into pdt values (null,?,?,?,?)";
        try {
			pr=con.prepareStatement(sql);
			pr.setString(1, pdt.getQuestion());
			pr.setString(2, pdt.getAnswer());
			pr.setInt(3, pdt.getQuestiontype());
			pr.setString(4, pdt.getQuestionpoint());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
	
		
		return row>0;
	}

	@Override
	public boolean delete(Pdt pdt) {
		int row=0;
        con=DBUtil.getConnection();
        String sql="delete from pdt where id=?";
        try {
			pr=con.prepareStatement(sql);
			pr.setInt(1, pdt.getId());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}

	@Override
	public boolean update(Pdt pdt) {
		int row=0;
        con=DBUtil.getConnection();
        //题目种类不会变
        String sql="update pdt set question=?,answer=? where id=?";
        try {
			pr=con.prepareStatement(sql);	
			pr.setString(1, pdt.getQuestion());
			pr.setString(2, pdt.getAnswer());
			pr.setInt(3, pdt.getId());
			
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}

	@Override
	public List<Pdt> select() {
		List<Pdt> list=new ArrayList<Pdt>();
		String sql="select * from pdt";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			rs=pr.executeQuery();
			while (rs.next()) {
				Pdt pdt=new Pdt();
				pdt.setId(rs.getInt("id"));
				pdt.setQuestion(rs.getString("question"));
				pdt.setAnswer(rs.getString("answer"));
				pdt.setQuestiontype(5);
				pdt.setQuestionpoint(rs.getString("questionpoint"));
				list.add(pdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}

	public Pdt select(int id) {
		String sql="select * from pdt where id=?";
		  con=DBUtil.getConnection();
		  Pdt pdt=null;
		  try {
			pr=con.prepareStatement(sql);
			pr.setInt(1, id);
			rs=pr.executeQuery();
			while (rs.next()) {
				pdt=new Pdt();
				pdt.setId(rs.getInt("id"));
				pdt.setQuestion(rs.getString("question"));
				pdt.setAnswer(rs.getString("answer"));
				pdt.setQuestiontype(5);
				pdt.setQuestionpoint(rs.getString("questionpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return pdt;
	}
	
	@Override
	public List<Pdt> select(String questionpoint) {
		List<Pdt> list=new ArrayList<Pdt>();
		String sql="select * from pdt where questionpoint=?";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			pr.setString(1, questionpoint);
			rs=pr.executeQuery();
			while (rs.next()) {
				Pdt pdt=new Pdt();
				pdt.setId(rs.getInt("id"));
				pdt.setQuestion(rs.getString("question"));
				pdt.setAnswer(rs.getString("answer"));
				pdt.setQuestiontype(5);
				pdt.setQuestionpoint(rs.getString("questionpoint"));
				list.add(pdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}

}
