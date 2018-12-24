package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import caozuo.StudentInterfaceCao;
import caozuo.StudentInterfaceImplCao;


/**
 * Servlet implementation class cjservlet
 */



public class ShowUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowUserInfo() {
        super();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	StudentInterfaceBiz service = new StudentInterfaceImplBiz();
    	String type=request.getParameter("type");
		List<Student> s = new ArrayList();
			try {
				s = service.selectall();
				System.out.println(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("Student", s);	
		//将list数据发送到.jsp文件中
			if(type.equals("2")) {
				response.sendRedirect("teacher/manage_student.jsp");
			}
			if(type.equals("3")) {
				response.sendRedirect("Manager/manage_student.jsp");
			}
	 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

