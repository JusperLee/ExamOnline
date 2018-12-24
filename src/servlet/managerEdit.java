package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manager;
import bean.Teacher;
import caozuo.ManagerInterfaceCao;
import caozuo.ManagerInterfaceImplCao;
import caozuo.TeacherInterfaceCao;
import caozuo.TeacherInterfaceImplCao;

/**
 * Servlet implementation class managerEdit
 */
@WebServlet("/managerEdit")
public class managerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println(id);
		ManagerInterfaceCao mc=new ManagerInterfaceImplCao();
		Manager m=null;
		try {
			m=mc.showManagerInfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("Manager1", m);
		String type=request.getParameter("type");
		if(type.equals("2")) {
			request.getSession().setAttribute("manager_success", "ÐÞ¸Ä³É¹¦");
		}
		response.sendRedirect("Manager/ManagerSelf.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
