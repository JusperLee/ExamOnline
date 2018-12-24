package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manager;
import bean.Student;
import bean.Teacher;
import db.DBUtil;

/**
 * 更新个人信息，看参数
 * 
 * @author Administrator
 *
 */
public class UploadSelfInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadSelfInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String type = request.getParameter("usertype");

		String username = (String) request.getParameter("username");
		String pwd = (String) request.getParameter("pwd");
		String name = (String) request.getParameter("name");
		String telephone = (String) request.getParameter("telephone");
		System.out.println("username"+(String)username);
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		if (type.equals("1")) {
			System.out.println(username);
			String studentclass = (String) request.getParameter("sclass");
			Student s = new Student(username, pwd, name, studentclass, telephone);
			String sql="update student_info set stu_name=?,stu_tel=AES_ENCRYPT(?,'dimtim'),stu_class=AES_ENCRYPT(?,'dimtim'),stu_password=AES_ENCRYPT(?,'dimtim') where stu_number=AES_ENCRYPT(?,'dimtim')";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, telephone);
				pst.setString(3, studentclass);
				pst.setString(4, pwd);
				pst.setString(5, username);
				int res=pst.executeUpdate();
				if(res>0){
					System.out.println("更新数据成功");
				}
				DBUtil.CloseConnection(rs,pst, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("Student", s);
		//	System.out.println(request.getSession().getAttribute("Student")+">>>>>>>>>>");
			//request.getRequestDispatcher("/student/index.jsp").forward(request, response);
			// 更新后重定向到学生首页。
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.print("<script type=\"text/javascript\" language=\"javascript\">");
			out.print("alert('successful!!!');");
			out.print("window.location='Student/index.jsp';");
			out.print("</script>");
			out.print("</body></html>");
			
			return;
		}
		if (type.equals("2")) {
            String auth=(String)request.getParameter("auth");
			Teacher t = new Teacher(username, pwd, name, telephone,auth);
            System.out.println(telephone.toString());
            String sql="update teacher_info set tea_name=?,tea_tel=AES_ENCRYPT(?,'dimtim'),tea_auth=AES_ENCRYPT(?,'dimtim'),stu_password=AES_ENCRYPT(?,'dimtim') where tea_num=AES_ENCRYPT(?,'dimtim')";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, telephone);
				pst.setString(3, auth);
				pst.setString(4, pwd);
				pst.setString(5, username);
				int res=pst.executeUpdate();
				if(res>0){
					System.out.println("更新数据成功");
				}
				DBUtil.CloseConnection(rs,pst, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("Teacher", t);
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.print("<script type=\"text/javascript\" language=\"javascript\">");
			out.print("alert('successful!!!');");
			out.print("window.location='teacher/index.jsp';");
			out.print("</script>");
			out.print("</body></html>");
			// 更新后重定向至教师首页。
			//response.sendRedirect("teacher/index.jsp");
			return;
		}
		if (type.equals("3")) {

			Manager m = new Manager(username, pwd, name, telephone);
			String sql="update admin_info set admin_name=?,admin_tel=AES_ENCRYPT(?,'dimtim'),admin_password=AES_ENCRYPT(?,'dimtim') where admin_num=AES_ENCRYPT(?,'dimtim')";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, telephone);
				pst.setString(4, pwd);
				pst.setString(5, username);
				int res=pst.executeUpdate();
				if(res>0){
					System.out.println("更新数据成功");
				}
				DBUtil.CloseConnection(rs,pst, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("Manager", m);
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.print("<script type=\"text/javascript\" language=\"javascript\">");
			out.print("alert('successful!!!');");
			out.print("window.location='manager/index.jsp';");
			out.print("</script>");
			out.print("</body></html>");
			// 更新后重定向至管理员首页。
			//response.sendRedirect("manager/index.jsp");
			return;
		}

	}

}
