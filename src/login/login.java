package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manager;
import bean.Student;
import bean.Teacher;
import caozuo.TeacherInterfaceCao;
import caozuo.ManagerInterfaceCao;
import caozuo.ManagerInterfaceImplCao;
import caozuo.TeacherInterfaceImplCao;
import db.DBUtil;
import servlet.StudentInterfaceBiz;
import servlet.StudentInterfaceImplBiz;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得ServletContext对象
		String uname = request.getParameter("id");
		String upsw = request.getParameter("password");
		String tel=request.getParameter("tel_num2");
		String yan=request.getParameter("yan");
		String yan1=(String) request.getSession().getAttribute("yan1");
		String message1 = null;
		String message2 = null;
		StudentInterfaceBiz service = new StudentInterfaceImplBiz();
		TeacherInterfaceCao tea = new TeacherInterfaceImplCao();
		ManagerInterfaceCao man = new ManagerInterfaceImplCao();
		
		
		Student stu= null;
		Teacher te = null;
		Manager ma = null;
		int r =0;
		try {
			if(yan.equals(yan1)) {
				System.out.println("即将进行登录检测");
				stu = service.login(uname, upsw,tel);
				te = tea.login(uname, upsw,tel);
				ma = man.login(uname, upsw,tel);
				System.out.println("登录检测完毕，即将跳转");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(stu !=null) {
			r = stu.getRu();
			request.getSession().setAttribute("adminPower", (int)r);
			System.out.println(r);
			
			Cookie c1 = new Cookie("UserId",uname);
			response.addCookie(c1);
		}
		else if(te !=null) {
			
			Cookie c1 = new Cookie("UserId",uname);
			response.addCookie(c1);
			r = te.getRu();
			request.getSession().setAttribute("adminPower", (int)r);
			System.out.println(r);
		}
		else if(ma !=null) {
			Cookie c1 = new Cookie("UserId",uname);
			response.addCookie(c1);
			r = ma.getRu();
			request.getSession().setAttribute("adminPower", (int)r);
			System.out.println(r);
		}
		else {
			message1 = String.format(
					"<font color='red'>对不起，用户名或密码或手机号有误！,请重新输入</font>");
	        request.setAttribute("message1",message1);
        	request.getRequestDispatcher("/login.jsp").forward(request, response);		
		}
		if(r == 3) {
			//跳到管理员界面
			Connection con = DBUtil.getConnection();
			 message1 = String.format(
						"管理员登陆成功！");
			 message2 = String.format(
						"/web_big_homework/Manager/index.jsp");
			 			request.getSession().setAttribute("Manager",ma);
			Manager m=null;
			try {
				m=man.showManagerInfo(uname);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("Manager", m);
		}
		else if(r==2){
			//跳到教师界面
			 message1 = String.format(
						"教师登陆成功！");
			 message2 = String.format(
						"/web_big_homework/teacher/index.jsp");
			 List<Student> s = new ArrayList();
			try {
				s = service.selectall();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 request.getSession().setAttribute("Student", s);
			  request.getSession().setAttribute("Teacher",te);
	}
		else if(r == 1) {
			System.out.println(stu.toString());
			System.out.println("跳到学生登录成功页面");
			//跳转到学生页面
			 message1 = String.format(
						"学生登陆成功！");
			 message2 = String.format(
						"/web_big_homework/Student/index.jsp");
			System.out.println(message2);
		  request.getSession().setAttribute("Student",stu);
		}
		request.setAttribute("message2",message2);
		request.setAttribute("message1",message1);
		request.getSession().setAttribute("message2",message2);
		request.getSession().setAttribute("message1",message1);
		request.getRequestDispatcher("/login_message.jsp").forward(request, response);
		
	}

}
