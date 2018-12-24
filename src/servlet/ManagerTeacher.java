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

import bean.Manager;
import bean.Student;
import bean.Teacher;
import caozuo.ManagerInterfaceCao;
import caozuo.ManagerInterfaceImplCao;
import caozuo.TeacherInterfaceCao;
import caozuo.TeacherInterfaceImplCao;
import db.DBUtil;

/**
 * Servlet implementation class ManagerTeacher
 */
@WebServlet("/ManagerTeacher")
public class ManagerTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager m=(Manager) request.getSession().getAttribute("Manager");
		if(m.getId()==null || m.getId().equals("")) {
			response.sendRedirect("Manager/index.jsp");
		}
		else {
			ManagerInterfaceCao service = new ManagerInterfaceImplCao();
			List<Teacher> s = new ArrayList();
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				s=service.select(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("TeacherInfo", s);
			System.out.println("≤È—Ø≥…π¶");
			response.sendRedirect("Manager/managerTeacher.jsp");
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
