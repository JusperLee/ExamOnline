package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBUtil;

/**
 * Servlet implementation class paperUpdate
 */
@WebServlet("/paperUpdate")
public class paperUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paperUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String paperid=request.getParameter("paperid");
		String papername=request.getParameter("papername");
		String paperstart=request.getParameter("paperstart");
		String paperend=request.getParameter("paperend");
		String papertime=request.getParameter("papertime");
		String paperclass=request.getParameter("paperclass");
		String paperpoint=request.getParameter("paperpoint");
		Connection con=DBUtil.getConnection();
		PreparedStatement pr =null;
		ResultSet rs =null;
		String sql="update paper set starttime=?,endtime=?,papername = ?,class=?,paperpoint=?,time=? where id = ?";
		Timestamp	start = java.sql.Timestamp.valueOf(paperstart);
		Timestamp	end = java.sql.Timestamp.valueOf(paperstart);
		Time time=java.sql.Time.valueOf(papertime);
		try {
			pr=con.prepareStatement(sql);
			pr.setTimestamp(1, start);
			pr.setTimestamp(2, end);
			pr.setString(3, papername);
			pr.setString(4, paperclass);
			pr.setString(5, paperpoint);
			pr.setTime(6, time);
			pr.setInt(7, Integer.parseInt(paperid));
			int n=pr.executeUpdate();
			if(n>0) {
				System.out.println("插入成功");
				request.getSession().setAttribute("msg1", "更新成功");
				response.sendRedirect("Manager/paperEdit.jsp");
			}
			else{
				System.out.println("插入失败");
				request.getSession().setAttribute("msg1", "更新失败");
				response.sendRedirect("Manager/paperEdit.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
