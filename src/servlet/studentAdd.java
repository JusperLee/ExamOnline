package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;

/**
 * Servlet implementation class studentAdd
 */
@WebServlet("/studentAdd")
public class studentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("studentId");
		String stu_class=request.getParameter("classId");
		String stu_name = request.getParameter("studentName");
		String stu_tel=request.getParameter("student_tel");
		String stu_pwd = request.getParameter("studentPwd");
		String type=request.getParameter("type");
		Student s=new Student(userid, stu_pwd, stu_name,stu_class, stu_tel);
		StudentInterfaceBiz stub=new StudentInterfaceImplBiz();
		System.out.println(s);
		if(userid==null) {
			response.sendRedirect("ShowUserInfo");
		}
		boolean b=false;
		if(userid!=null) {
			try {
			b = stub.insert(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(type.equals("3"))
		{
			if(b==true) {
				String message2="添加学生成功";
				request.getSession().setAttribute("msg1", message2);
				response.sendRedirect("Manager/studentAdd.jsp");
			}
			else {
				String message2="添加学生失败";
				request.getSession().setAttribute("msg1", message2);
				response.sendRedirect("Manager/studentAdd.jsp");
			}
		}
		if(type.equals("2")) {
			if(b==true) {
				String message2="添加学生成功";
				request.getSession().setAttribute("msg1", message2);
				response.sendRedirect("teacher/studentAdd.jsp");
			}
			else {
				String message2="添加学生失败";
				request.getSession().setAttribute("msg1", message2);
				response.sendRedirect("teacher/studentAdd.jsp");
			}
		}
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
