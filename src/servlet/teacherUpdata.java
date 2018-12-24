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
 * Servlet implementation class teacherUpdata
 */
@WebServlet("/teacherUpdata")
public class teacherUpdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherUpdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacherid=request.getParameter("teacherid");
		String teachername=request.getParameter("teacherName");
		String teachertel=request.getParameter("teachertel");
		String teacherpwd=request.getParameter("teacherpwd");
		String teacherauth=request.getParameter("teacherauth");
		String type=request.getParameter("type");
		System.out.println("type="+type);
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		String sql = "update teacher_info set tea_password = AES_ENCRYPT(?,'dimtim'),tea_auth=AES_ENCRYPT(?,'dimtim'),tea_tel=AES_ENCRYPT(?,'dimtim') where tea_num = AES_ENCRYPT(?,'dimtim')";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, teacherpwd);
			pst.setString(2, teacherauth);
			pst.setString(3, teachertel);
			pst.setString(4, teacherid);
			int n=pst.executeUpdate();
			if(n>0) {
				System.out.println("更新成功");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("teacherEdit?type="+type+"&id="+teacherid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
