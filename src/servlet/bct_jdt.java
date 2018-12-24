package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.StudentGrade;
import caozuo.StudentGradeInterfaceCao;
import caozuo.StudentGradeInterfaceImplCao;
import db.DBUtil;

/**
 * Servlet implementation class bct_jdt
 */
@WebServlet("/bct_jdt")
public class bct_jdt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bct_jdt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int[] bct_score=new int[2];
		int[] jdt_score=new int[2];
		for(int i = 0;i<2;i++) {
			jdt_score[i]=Integer.parseInt((String)request.getParameter(String.valueOf(i+1)));
		}
		for(int i=2;i<4;i++) {
			bct_score[i-2]=Integer.parseInt((String)request.getParameter(String.valueOf(i+1)));
		}
		Student s=(Student) request.getSession().getAttribute("student");
		String paperid=(String) request.getSession().getAttribute("paper_number");
		String sql="select * from studentgrade where stu_number=? and paperid=?";
		StudentGrade sgrade=new StudentGrade();
		StudentGradeInterfaceCao sc=new StudentGradeInterfaceImplCao();
		Connection con = DBUtil.getConnection();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr=con.prepareStatement(sql);
			pr.setString(1, s.getId());
			pr.setInt(2, Integer.parseInt(paperid));
			rs=pr.executeQuery();
			while(rs.next()) {
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
			}
			int score=0;
			score=sgrade.getXztscore()+sgrade.getTktscore()+sgrade.getPdtscore()+jdt_score[0]
					+jdt_score[1]+bct_score[0]+bct_score[1];
			int jdt=jdt_score[0]+jdt_score[1];
			int bct=bct_score[0]+bct_score[1];
			boolean b=sc.update(bct, jdt,score,s.getId(),sgrade.getPapername());
			if(b==true) {
				System.out.println("更新成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("teacher/checkPaper.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
