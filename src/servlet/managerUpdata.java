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
 * Servlet implementation class managerUpdata
 */
@WebServlet("/managerUpdata")
public class managerUpdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerUpdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
				String managerid=request.getParameter("managerid");
				String managername=request.getParameter("managerName");
				String managertel=request.getParameter("managertel");
				String managerpwd=request.getParameter("managerpwd");
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				con = DBUtil.getConnection();
				String sql = "update admin_info set admin_password = AES_ENCRYPT(?,'dimtim'),admin_name=?,admin_tel=AES_ENCRYPT(?,'dimtim') where admin_num = AES_ENCRYPT(?,'dimtim')";
				try {
					pst=con.prepareStatement(sql);
					pst.setString(1, managerpwd);
					pst.setString(2, managername);
					pst.setString(3, managertel);
					pst.setString(4, managerid);
					int n=pst.executeUpdate();
					if(n>0) {
						System.out.println("更新成功");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("manageredit?type=2&id="+managerid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
