/*
 * author likai
 */

package tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Bct;
import bean.Jdt;
import bean.Paper;
import bean.PaperString;
import bean.Pdt;
import bean.Tkt;
import bean.Xzt;
import db.DBUtil;

public class QuestionInstance {
	private static Connection con = null;
	private static PreparedStatement pr = null;
	private static ResultSet rs = null;

	/**
	 * 用来将paper对象封装成paperstring对象
	 * @author 李凯
	 *
	 */
	public static PaperString changeToPaperString(Paper paper){
		Xzt xzt1=getXzt(paper.getXzt1());
		Xzt xzt2=getXzt(paper.getXzt2());
		Xzt xzt3=getXzt(paper.getXzt3());
		Xzt xzt4=getXzt(paper.getXzt4());
		Xzt xzt5=getXzt(paper.getXzt5());
		Xzt xzt6=getXzt(paper.getXzt6());
		Xzt xzt7=getXzt(paper.getXzt7());
		Xzt xzt8=getXzt(paper.getXzt8());
		Xzt xzt9=getXzt(paper.getXzt9());
		Xzt xzt10=getXzt(paper.getXzt10());
		Tkt tkt1=getTkt(paper.getTkt1());
		Tkt tkt2=getTkt(paper.getTkt2());
		Tkt tkt3=getTkt(paper.getTkt3());
		Tkt tkt4=getTkt(paper.getTkt4());
		Tkt tkt5=getTkt(paper.getTkt5());
		Pdt pdt1=getPdt(paper.getPdt1());
		Pdt pdt2=getPdt(paper.getPdt2());
		Pdt pdt3=getPdt(paper.getPdt3());
		Jdt jdt1 = getJdt(paper.getJdt1());
		Jdt jdt2 = getJdt(paper.getJdt2());
		Bct bct1=getBct(paper.getBct1());
		Bct bct2=getBct(paper.getBct2());
		PaperString ps=new PaperString(xzt1, xzt2, xzt3, xzt4, xzt5,
				xzt6, xzt7, xzt8, xzt9, xzt10,
				tkt1, tkt2, tkt3, tkt4, tkt5, pdt1,pdt2,pdt3,jdt1,jdt2,
				bct1, bct2);
		ps.setPapername(paper.getPapername());
		ps.setStarttime(paper.getStarttime());
		ps.setEndtime(paper.getEndtime());
		ps.setTime(paper.getTime());
		System.out.println(paper.getTime());
		ps.setId(paper.getId());
		ps.setClass1(paper.getClass1());
		return ps;
		
	}
	
	public static Xzt getXzt(int id) {
		Xzt xzt = new Xzt();
		String sql = "select * from xzt where id='" + id + "'";
		con = DBUtil.getConnection();
		try {
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				xzt.setId(rs.getInt("id"));
				xzt.setQuestion(rs.getString("question"));
				xzt.setAnswer(rs.getString("answer"));
				xzt.setOptionA(rs.getString("optionA"));
				xzt.setOptionB(rs.getString("optionB"));
				xzt.setOptionC(rs.getString("optionC"));
				xzt.setOptionD(rs.getString("optionD"));
				xzt.setQuestiontype(1);
				xzt.setQuestionpoint(rs.getString("questionpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return xzt;

	}

	public static Tkt getTkt(int id) {
		Tkt tkt = new Tkt();
		String sql = "select * from tkt where id='" + id + "'";
		con = DBUtil.getConnection();
		try {
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				tkt.setId(rs.getInt("id"));
				tkt.setQuestion(rs.getString("question"));
				tkt.setAnswer(rs.getString("answer"));
				tkt.setQuestiontype(2);
				tkt.setQuestionpoint(rs.getString("questionpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return tkt;

	}
	
	public static Pdt getPdt(int id) {
		Pdt pdt = new Pdt();
		String sql = "select * from pdt where id='" + id + "'";
		con = DBUtil.getConnection();
		try {
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				pdt.setId(rs.getInt("id"));
				pdt.setQuestion(rs.getString("question"));
				pdt.setAnswer(rs.getString("answer"));
				pdt.setQuestiontype(5);
				pdt.setQuestionpoint(rs.getString("questionpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return pdt;

	}
	
	public static Jdt getJdt(int id) {
		Jdt jdt = new Jdt();
		String sql = "select * from jdt where id='" + id + "'";
		con = DBUtil.getConnection();
		try {
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				jdt.setId(rs.getInt("id"));
				jdt.setQuestion(rs.getString("question"));
				jdt.setQuestiontype(4);
				jdt.setQuestionpoint(rs.getString("questionpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return jdt;


	}
	
	public static Bct getBct(int id) {
		Bct bct = new Bct();
		String sql = "select * from bct where id='" + id + "'";
		con = DBUtil.getConnection();
		try {
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				bct.setId(rs.getInt("id"));
				bct.setQuestion(rs.getString("question"));
				bct.setQuestiontype(3);
				bct.setQuestionpoint(rs.getString("questionpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return bct;


	}

}
