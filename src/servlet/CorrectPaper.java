package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BctAnswer;
import bean.Student;
import caozuo.BctAnswerInterfaceCao;
import caozuo.BctAnswerInterfaceImplCao;
import caozuo.StudentInterfaceCao;
import caozuo.StudentInterfaceImplCao;
import db.DBUtil;


public class CorrectPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CorrectPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+"123");
		//String studentname=request.getParameter("username");
		//String papername=request.getParameter("papername");
		String studentname=request.getParameter("fang");
		String papername=request.getParameter("测试试卷二");
		studentname="fang";
		papername="测试试卷二";
		BctAnswerInterfaceCao bf=new BctAnswerInterfaceImplCao();
		List<BctAnswer> bca=new ArrayList<BctAnswer>();
		List<BctAnswer> bcw=new ArrayList<BctAnswer>();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+"456");
		bca=bf.select(studentname, papername);//wp
		bcw=bf.selectwp(studentname, papername);//yp
		System.out.println(bca.toString());
		System.out.println(bcw.toString());
		bca.forEach(i->System.out.println(i.toString()+"123"));
		bcw.forEach(i->System.out.println(i.toString()+"456"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+"789");
		request.getSession().setAttribute("Bctanwseryp", bcw);
		request.getSession().setAttribute("Bctanwserwp", bca);*/
		String paperid=request.getParameter("papername");
		String stu_number=request.getParameter("username");
		StudentInterfaceCao sc=new StudentInterfaceImplCao();
		Student t=null;
		Connection con = DBUtil.getConnection();
		PreparedStatement pr = null;
		ResultSet rs = null;
		int[] jdtid=new int[2];
		int[] bctid=new int[2];
		String[] jdt=new String[2];
		String[] jdtqu=new String[2];
		String[] bct=new String[2];
		String[] bctqu=new String[2];
		String sql="select * from studentanswer where paper_id=? and stu_number=?";
		String sql1="select question from jdt where id=?";
		String sql2="select question from bct where id=?";
		String sql3="select * from paper where id=?";
		try {
			pr=con.prepareStatement(sql);
			pr.setInt(1, Integer.parseInt(paperid));
			pr.setString(2, stu_number);
			rs=pr.executeQuery();
			while(rs.next()) {
				jdt[0]=rs.getString("jdt1");
				jdt[1]=rs.getString("jdt2");
				bct[0]=rs.getString("bct1");
				bct[1]=rs.getString("bct2");
			}
			t=sc.showuserinfo(stu_number);
			
			pr=con.prepareStatement(sql3);
			pr.setInt(1, Integer.parseInt(paperid));
			rs=pr.executeQuery();
			while(rs.next()) {
				jdtid[0]=rs.getInt("jdt1");
				jdtid[1]=rs.getInt("jdt2");
				bctid[0]=rs.getInt("bct1");
				bctid[1]=rs.getInt("bct2");
			}
			
			pr=con.prepareStatement(sql1);
			pr.setInt(1, jdtid[0]);
			rs=pr.executeQuery();
			while(rs.next()) {
				jdtqu[0]=rs.getString("question");
			}
			
			
			pr=con.prepareStatement(sql1);
			pr.setInt(1, jdtid[1]);
			rs=pr.executeQuery();
			while(rs.next()) {
				jdtqu[1]=rs.getString("question");
			}
			
			pr=con.prepareStatement(sql2);
			pr.setInt(1, bctid[0]);
			rs=pr.executeQuery();
			while(rs.next()) {
				bctqu[0]=rs.getString("question");
			}
			
			pr=con.prepareStatement(sql2);
			pr.setInt(1, bctid[1]);
			rs=pr.executeQuery();
			while(rs.next()) {
				bctqu[1]=rs.getString("question");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//重定向
		request.getSession().setAttribute("stu_jdt", jdt);
		request.getSession().setAttribute("stu_bct", bct);
		request.getSession().setAttribute("stu_jdt_qu", jdtqu);
		request.getSession().setAttribute("stu_bct_qu", bctqu);
		request.getSession().setAttribute("student", t);
		request.getSession().setAttribute("paper_number", paperid);
		System.out.println(jdt[0]);
		System.out.println(bct[0]);
		System.out.println(bctqu[0]);
		
		response.sendRedirect("teacher/uncompletePaper2.jsp");
		
//向前端传递数据
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
