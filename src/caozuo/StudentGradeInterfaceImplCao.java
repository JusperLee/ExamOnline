package caozuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.StudentGrade;
import caozuo.StudentGradeInterfaceCao;
import db.DBUtil;

public class StudentGradeInterfaceImplCao implements StudentGradeInterfaceCao {
	private static Connection con = null;
	private static PreparedStatement pr = null;
	private static ResultSet rs = null;

	
	/**
	 * ����һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	@Override
	public boolean insert(StudentGrade studentGrade) {
		int row=0;
        con=DBUtil.getConnection();
        System.out.println(studentGrade.getPaperId());
        String sql="insert into studentgrade (stu_number,Xztscore,Tktscore,Pdtscore,Jdtscore,Bctscore,score,Papername,paperid)values (?,?,?,?,?,?,?,?,?,?)";
        try {
			pr=con.prepareStatement(sql);
			pr.setString(1, studentGrade.getUserId());
			pr.setString(2, studentGrade.getName());
			pr.setInt(3, studentGrade.getXztscore());
			pr.setInt(4, studentGrade.getTktscore());
			pr.setInt(5, studentGrade.getPdtscore());
			pr.setInt(6, studentGrade.getJdtscore());
			pr.setInt(7, studentGrade.getBctscore());
			pr.setInt(8, studentGrade.getscore());
			pr.setString(9, studentGrade.getPapername());
			pr.setInt(10, studentGrade.getPaperId());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
	
		
		return row>0;
	}
	/**
	 * ɾ��һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	@Override
	public boolean delete(StudentGrade studentGrade) {
		int row=0;
        con=DBUtil.getConnection();
        String sql="delete from studentgrade where stu_number=? and Papername=?";
        try {
        	pr=con.prepareStatement(sql);
			pr.setString(1, studentGrade.getUserId());
			pr.setString(2, studentGrade.getPapername());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}

	
	/**
	 * �޸�һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	@Override
	public boolean update(int bctscore,int jdtscore,int score,String username,String papername) {
		int row=0;
        con=DBUtil.getConnection();
        //��Ŀ���಻���
        String sql="update studentgrade set  Bctscore=?,Jdtscore=?,score=? where stu_number=? and Papername=?";
        try {
			pr=con.prepareStatement(sql);	
			
			pr.setInt(1, bctscore);
			pr.setInt(2, jdtscore);
			pr.setInt(3, score);
			pr.setString(4,username);
		   
			pr.setString(5, papername);

			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}
	/**
	 * ��ѯĳ��ѧ����ȫ���ɼ���¼
	 * @param username ѧ������
	 * @return ĳ��ѧ����ȫ���ɼ���¼StudentGrade
	 */
	@Override
	public List<StudentGrade> select(String username) {
		List<StudentGrade> list=new ArrayList<StudentGrade>();
		String sql="select * from studentgrade where stu_number=?";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			pr.setString(1, username);
			rs=pr.executeQuery();
			while (rs.next()) {
				StudentGrade sgrade=new StudentGrade();
				sgrade.setUserId(rs.getString("stu_number"));
				sgrade.setName(rs.getString("stu_name"));
				sgrade.setXztscore(rs.getInt("Xztscore"));
				sgrade.setTktscore(rs.getInt("Tktscore"));
				sgrade.setBctscore(rs.getInt("Bctscore"));
				sgrade.setJdtscore(rs.getInt("Jdtscore"));
				sgrade.setPdtscore(rs.getInt("Pdtscore"));
				sgrade.setscore(rs.getInt("score"));
				sgrade.setPapername(rs.getString("Papername"));
				sgrade.setPaperId(rs.getInt("paperid"));
				list.add(sgrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}
	
/**
 * ��ѯĳ���Ծ���ĳ���༶��ȫ���ɼ���¼
 * @param studentclass ѧ�����ڰ༶
 * @param  papername �Ծ���
 * @return ĳ���Ծ��ȫ���ɼ���¼
 */
	@Override
	public List<StudentGrade> select(String studentclass, String papername) {
		System.out.println("<<<<<<<<<<<<<<<,");
		List<StudentGrade> list=new ArrayList<StudentGrade>();
		String sql="select * from studentgrade where paperid =(select id from paper where class=? and papername=?)";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
		    pr.setString(1, studentclass);
			pr.setString(2, papername);
			rs=pr.executeQuery();
			while (rs.next()) {
				StudentGrade sgrade=new StudentGrade();
				sgrade.setUserId(rs.getString("stu_number"));
				sgrade.setName(rs.getString("stu_name"));
				sgrade.setXztscore(rs.getInt("Xztscore"));
				sgrade.setTktscore(rs.getInt("Tktscore"));
				sgrade.setBctscore(rs.getInt("Bctscore"));
				sgrade.setJdtscore(rs.getInt("Jdtscore"));
				sgrade.setPdtscore(rs.getInt("Pdtscore"));
				sgrade.setscore(rs.getInt("score"));
				sgrade.setPapername(rs.getString("Papername"));
				sgrade.setPaperId(rs.getInt("paperid"));
				list.add(sgrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			  System.out.println(list);
			DBUtil.CloseConnection(rs, pr, con);
		}	
		
		return list;
	}

}
