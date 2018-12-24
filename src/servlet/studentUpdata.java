package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import caozuo.StudentInterfaceCao;
import caozuo.StudentInterfaceImplCao;

/**
 * Servlet implementation class studentUpdata
 */
@WebServlet("/studentUpdata")
public class studentUpdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentUpdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("studentId");
		String stu_class=request.getParameter("classId");
		String stu_name = request.getParameter("studentName");
		String stu_tel=request.getParameter("student_tel");
		String stu_pwd=request.getParameter("studentPwd");
		String type=request.getParameter("type");
		String auth="1";
		Student s=new Student(userid, stu_pwd, stu_name,stu_class, stu_tel);
		StudentInterfaceBiz stuc=new StudentInterfaceImplBiz();
		Student s1=new Student(userid, stu_pwd, stu_name,stu_class, stu_tel);
		boolean b=false;
		
		if(type.equals("3")) {
			try {
				b=stuc.updata_manager(s);
				s=stuc.showuserinfo(userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(b==true) {
				request.getSession().setAttribute("message1", "修改成功");
				request.getSession().setAttribute("student_info", s);
				response.sendRedirect("Manager/studentEdit.jsp");
			}
			else {
				request.getSession().setAttribute("message1", "修改失败");
				response.sendRedirect("Manager/studentEdit.jsp");
			}
		}
		if(type.equals("2")) {
			try {
				b=stuc.updata(s);
				s=stuc.showuserinfo(userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(b==true) {
				request.getSession().setAttribute("message1", "修改成功");
				request.getSession().setAttribute("student_info", s);
				response.sendRedirect("teacher/studentEdit.jsp");
			}
			else {
				request.getSession().setAttribute("message1", "修改失败");
				response.sendRedirect("teacher/studentEdit.jsp");
			}
		}
		if(type.equals("1")) {
			try {
				b=stuc.updata(s);
				s=stuc.showuserinfo(userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(b==true) {
				request.getSession().setAttribute("message1", "修改成功");
				request.getSession().setAttribute("student_info", s);
				response.sendRedirect("Student/StudentSelf.jsp");
			}
			else {
				request.getSession().setAttribute("message1", "修改失败");
				response.sendRedirect("Student/StudentSelf.jsp");
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
