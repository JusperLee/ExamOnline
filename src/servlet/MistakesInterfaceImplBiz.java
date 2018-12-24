package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Bct;
import bean.Jdt;
import bean.Mistakes;
import bean.Pdt;
import bean.Tkt;
import bean.Xzt;
import caozuo.MistakesInterfaceCao;
import db.DBUtil;
import caozuo.MistakeInterfaceImplCao;
import servlet.MistakesInterfaceBiz;
import tool.QuestionInstance;
/*
 *  @author likai
 *  实现对错题的操作的接口实现
 */
public class MistakesInterfaceImplBiz implements MistakesInterfaceBiz {
	MistakesInterfaceCao mif= new MistakeInterfaceImplCao();
	private static Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	boolean b=false;
	@Override
	public boolean insert(Mistakes mistakes) {
		return mif.insert(mistakes);
	}

	@Override
	public boolean delete(Mistakes mistakes) {
		return mif.delete(mistakes);
	}

	@Override
	public List<Xzt> selectxzt(String username) {
		List<Mistakes> mi= mif.selectxzt(username);
		List<Xzt> xzt=new ArrayList<Xzt>();
		for (int i = 0; i <mi.size(); i++) {
			System.out.println(QuestionInstance.getXzt(mi.get(i).getQuestionid()).toString());
			xzt.add(QuestionInstance.getXzt(mi.get(i).getQuestionid()));
		}
		return xzt;
	}
	public List<Tkt> selecttkt(String username) {
		List<Mistakes> mi= mif.selecttkt(username);
		List<Tkt> tkt=new ArrayList<Tkt>();
		for (int i = 0; i <mi.size(); i++) {
			System.out.println(QuestionInstance.getTkt(mi.get(i).getQuestionid()).toString());
			tkt.add(QuestionInstance.getTkt(mi.get(i).getQuestionid()));
		}
		return tkt;
	}
	public List<Bct> selectbct(String username) {
		List<Mistakes> mi= mif.selectbct(username);
		List<Bct> bct=new ArrayList<Bct>();
		for (int i = 0; i <mi.size(); i++) {
			System.out.println(QuestionInstance.getBct(mi.get(i).getQuestionid()).toString());
			bct.add(QuestionInstance.getBct(mi.get(i).getQuestionid()));
		}
		return bct;
	}

	@Override
	public List<Mistakes> select(String username, String questionpoint) {
		return mif.select(username,questionpoint);
	}

	@Override
	public List<Mistakes> select(String username) {
        con=DBUtil.getConnection();
		List<Mistakes> list  = new ArrayList<Mistakes>();	
		String sql = "select * from Mistakes where username= ?";
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

	@Override
	public List<Pdt> selectpdt(String username) {
		List<Mistakes> mi= mif.selectpdt(username);
		List<Pdt> pdt=new ArrayList<Pdt>();
		for (int i = 0; i <mi.size(); i++) {
			System.out.println(QuestionInstance.getPdt(mi.get(i).getQuestionid()).toString());
			pdt.add(QuestionInstance.getPdt(mi.get(i).getQuestionid()));
		}
		return pdt;
	}
	@Override
	public List<Jdt> selectjdt(String username) {
		List<Mistakes> mi= mif.selectjdt(username);
		List<Jdt> jdt=new ArrayList<Jdt>();
		for (int i = 0; i <mi.size(); i++) {
			System.out.println(QuestionInstance.getJdt(mi.get(i).getQuestionid()).toString());
			jdt.add(QuestionInstance.getJdt(mi.get(i).getQuestionid()));
		}
		return jdt;
	}

}
