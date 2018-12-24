package servlet;

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

import bean.Student;
import bean.Teacher;
import caozuo.TeacherInterfaceCao;
import caozuo.TeacherInterfaceImplCao;
import db.DBUtil;

/**
 * Servlet implementation class teacheradd
 */
@WebServlet("/teacheradd")
public class teacheradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacheradd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("teacherId");
		String tea_auth=request.getParameter("teacherAuth");
		String tea_name = request.getParameter("teacherName");
		String tea_tel=request.getParameter("teacher_tel");
		String tea_pwd = request.getParameter("teacherPwd");
		Teacher t=new Teacher(userid, tea_pwd, tea_name,tea_tel, tea_auth);
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		System.out.println(t);
		if(userid==null) {
			response.sendRedirect("Managerteacher");
		}
		boolean b=false;
		int n;
		Teacher t1=null;
		String message2="";
		if(userid!=null) {
			TeacherInterfaceCao tc=new TeacherInterfaceImplCao();
			try {
				t1=tc.select(t, con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(t1.getId().equals("1") || t1.getId()=="1") {
				con = DBUtil.getConnection();
				String sql="insert into teacher_info values (?,2,AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'))";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1,tea_name);
				pst.setString(2,tea_auth);
				pst.setString(3,tea_tel);
				pst.setString(4, tea_pwd);
				pst.setString(5, userid);
			    n =pst.executeUpdate();
			    if(n>0) {
			    	System.out.println("成功");
					message2="添加老师成功";
					
				}
				else {
					System.out.println("失败");
					message2="添加老师失败";
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			}
			
		}
		request.getSession().setAttribute("message_success", message2);
		response.sendRedirect("Manager/teacherAdd.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
