package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import caozuo.StudentInterfaceCao;
import caozuo.StudentInterfaceImplCao;

/**
 * Servlet implementation class studentEdit
 */
@WebServlet("/studentEdit")
public class studentEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String type=request.getParameter("type");
		System.out.println(id);
//		StudentInterfaceBiz stu = new StudentInterfaceImplBiz();
		StudentInterfaceCao stuc = new StudentInterfaceImplCao();
		StudentInterfaceBiz stub=new StudentInterfaceImplBiz();
		Student s = null;
		try {
			s=stuc.showuserinfo(id);
			request.getSession().setAttribute("student_info", s);
			System.out.println(s);
			if(type.equals("1")) {
				List<Student> list=new ArrayList();
				list=stub.selectall();
				request.getSession().setAttribute("class1", list);
				response.sendRedirect("Student/StudentSelf.jsp");
			}
			if(type.equals("2"))
			{
				response.sendRedirect("teacher/studentEdit.jsp");
			}
			if(type.equals("3")) {
				response.sendRedirect("Manager/studentEdit.jsp");
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
