package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import caozuo.TeacherInterfaceCao;
import caozuo.TeacherInterfaceImplCao;

/**
 * Servlet implementation class teacheredit
 */
@WebServlet("/teacheredit")
public class teacheredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacheredit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String type=request.getParameter("type");
		System.out.println(id);
		TeacherInterfaceCao sc=new TeacherInterfaceImplCao();
		Teacher t=null;
		try {
			t=sc.showTeacherInfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(type.equals("2")) {
			request.getSession().setAttribute("Teacher1", t);
		response.sendRedirect("teacher/teacherSelf.jsp");
		}
		if(type.equals("3")) {
			request.getSession().setAttribute("Teacher1", t);
			response.sendRedirect("Manager/teacherSelf.jsp");
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
