package caozuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Bct;
import caozuo.BctInterfaceCao;
import db.DBUtil;
	
public class BctInterfaceImplCao implements BctInterfaceCao {
	private static Connection con = null;
	private static PreparedStatement pr = null;
	private static ResultSet rs = null;

	@Override
	public boolean insert(Bct bct) {
		int row=0;
         con=DBUtil.getConnection();
         String sql="insert into bct values (null,?,?,?)";
         try {
			pr=con.prepareStatement(sql);
			pr.setString(1, bct.getQuestion());
			pr.setInt(2, bct.getQuestiontype());
			pr.setString(3, bct.getQuestionpoint());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
	
		
		return row>0;
	}

	@Override
	public boolean delete(Bct bct) {
		int row=0;
        con=DBUtil.getConnection();
        String sql="delete from bct where id=?";
        try {
			pr=con.prepareStatement(sql);
			pr.setInt(1, bct.getId());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}
/**
 * ֻ���޸����еĶ��󣬲��ܴ����½��Ķ�����Ϊû��IDֵ��
 */
	@Override
	public boolean update(Bct bct) {
		int row=0;
        con=DBUtil.getConnection();
        //��Ŀ���಻���
        String sql="update bct set question=? where id=?";
        try {
			pr=con.prepareStatement(sql);
			
			pr.setString(1, bct.getQuestion());
			pr.setInt(2, bct.getId());
			
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}

	@Override
	public List<Bct> select() {
		List<Bct> list=new ArrayList<Bct>();
		String sql="select * from bct";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			rs=pr.executeQuery();
			while (rs.next()) {
				Bct bct=new Bct();
				bct.setId(rs.getInt("id"));
				bct.setQuestion(rs.getString("question"));
				bct.setQuestiontype(3);
				bct.setQuestionpoint(rs.getString("questionpoint"));
				list.add(bct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}

	
	public Bct select(int id) {
		String sql="select * from bct where id=?";
		  con=DBUtil.getConnection();
		  Bct bct=null;
		  try {
			pr=con.prepareStatement(sql);
			pr.setInt(1, id);
			rs=pr.executeQuery();
			while (rs.next()) {
				bct=new Bct();
				bct.setId(rs.getInt("id"));
				bct.setQuestion(rs.getString("question"));
				bct.setQuestiontype(3);
				bct.setQuestionpoint(rs.getString("questionpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return bct;
	}
	
	@Override
	public List<Bct> select(String questionpoint) {
		List<Bct> list=new ArrayList<Bct>();
		String sql="select * from bct where questionpoint=?";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			pr.setString(1, questionpoint);
			rs=pr.executeQuery();
			while (rs.next()) {
				Bct bct=new Bct();
				bct.setId(rs.getInt("id"));
				bct.setQuestion(rs.getString("question"));
				bct.setQuestiontype(3);
				bct.setQuestionpoint(rs.getString("questionpoint"));
				list.add(bct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}

}
