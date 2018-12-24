package regist;

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

import bean.Manager;
import bean.Student;
import bean.Teacher;
import caozuo.ManagerInterfaceCao;
import caozuo.ManagerInterfaceImplCao;
import caozuo.StudentInterfaceCao;
import caozuo.StudentInterfaceImplCao;
import caozuo.TeacherInterfaceCao;
import caozuo.TeacherInterfaceImplCao;
import db.DBUtil;
import servlet.StudentInterfaceBiz;
import servlet.StudentInterfaceImplBiz;

/**
 * Servlet implementation class find
 */
@WebServlet("/find")
public class find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public find() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String uname = request.getParameter("id");
		String tel=request.getParameter("tel_num2");
		String pwd=request.getParameter("password1");
		String yan=request.getParameter("yan");
		String yan1=(String) request.getSession().getAttribute("yan1");
		String message1 = null;
		String message2 = null;
		StudentInterfaceCao service = new StudentInterfaceImplCao();
		TeacherInterfaceCao tea = new TeacherInterfaceImplCao();
		ManagerInterfaceCao man = new ManagerInterfaceImplCao();
		Student stu=null;
		Teacher tc=null;
		Manager ma=null;
		stu.setId(uname);
		stu.setTelephone(tel);
		stu.setPwd(pwd);
		tc.setId(uname);
		tc.setTelephone(tel);
		tc.setPwd(pwd);
		ma.setId(uname);
		ma.setTelephone(tel);
		ma.setPwd(pwd);
		if(yan.equals(yan1)) {
			try {
				boolean s=service.find(stu, con);
				boolean t=tea.find(tc, con);
				boolean m=man.find(ma, con);
				if(s==true) {
					message1="学生信息找回成功！";
					request.getSession().setAttribute("message1", message1);
					response.sendRedirect("/login.jsp");
				}
				if(t==true) {
					message1="教师信息找回成功！";
					request.getSession().setAttribute("message1", message1);
					response.sendRedirect("/login.jsp");
				}
				if(m==true) {
					message1="管理员信息找回成功！";
					request.getSession().setAttribute("message1", message1);
					response.sendRedirect("/login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
