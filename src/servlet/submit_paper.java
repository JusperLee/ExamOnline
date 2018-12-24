package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBUtil;

/**
 * Servlet implementation class submit_paper
 */
@WebServlet("/submit_paper")
public class submit_paper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submit_paper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int  paperid = Integer.parseInt(request.getParameter("paper_id"));
		String Student_Name = request.getParameter("stu_name");
		String Student_Class = request.getParameter("stu_class");
		String Student_id=request.getParameter("stu_number");
		String[] stu_xzt=new String[10];
		String[] stu_tkt=new String[5];
		String[] stu_pdt=new String[3];
		String[] stu_jdt=new String[2];
		String[] stu_bct=new String[2];
		for(int index=0;index<10;index++) {
			stu_xzt[index]=request.getParameter(String.valueOf(index+1));
		}
		for(int index=0;index<5;index++) {
			stu_tkt[index]=request.getParameter(String.valueOf(index+11));
		}
		for(int index=0;index<3;index++) {
			stu_pdt[index]=request.getParameter(String.valueOf(index+16));
		}
		for(int index=0;index<2;index++) {
			stu_jdt[index]=request.getParameter(String.valueOf(index+19));
		}
		for(int index=0;index<2;index++) {
			stu_bct[index]=request.getParameter(String.valueOf(index+21));
		}
		con = DBUtil.getConnection();
		String sql="insert into studentanswer values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, Student_Name);
			pst.setString(2, Student_Class);
			pst.setString(3, Student_id);
			pst.setInt(4, paperid);
			pst.setString(5, stu_xzt[0]);
			pst.setString(6, stu_xzt[1]);
			pst.setString(7, stu_xzt[2]);
			pst.setString(8, stu_xzt[3]);
			pst.setString(9, stu_xzt[4]);
			pst.setString(10, stu_xzt[5]);
			pst.setString(11, stu_xzt[6]);
			pst.setString(12, stu_xzt[7]);
			pst.setString(13, stu_xzt[8]);
			pst.setString(14, stu_xzt[9]);
			
			pst.setString(15, stu_tkt[0]);
			pst.setString(16, stu_tkt[1]);
			pst.setString(17, stu_tkt[2]);
			pst.setString(18, stu_tkt[3]);
			pst.setString(19, stu_tkt[4]);
			
			pst.setString(20, stu_pdt[0]);
			pst.setString(21, stu_pdt[1]);
			pst.setString(22, stu_pdt[2]);
			
			pst.setString(23, stu_jdt[0]);
			pst.setString(24, stu_jdt[1]);
			
			pst.setString(25, stu_bct[0]);
			pst.setString(26, stu_bct[1]);
			int n=pst.executeUpdate();
			if(n>0) {
				System.out.println("插入成功");
			}
			if(n<0) {
				System.out.println("插入失败");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
    finally {
		DBUtil.CloseConnection(rs, pst, con);
	}
		System.out.println(String.valueOf(paperid));
		response.sendRedirect("correct_Paper?stu_id="+Student_id+"&paperid="+String.valueOf(paperid));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
