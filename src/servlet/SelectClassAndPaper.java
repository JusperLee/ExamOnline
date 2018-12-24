package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import caozuo.TeacherInterfaceCao;

import caozuo.TeacherInterfaceImplCao;


public class SelectClassAndPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectClassAndPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	TeacherInterfaceCao teacherInterfaceCao = new TeacherInterfaceImplCao();
	String[] studentclass = null;
	try {
		studentclass = teacherInterfaceCao.selectclass();
	} catch (SQLException e1) {
		// TODO 自动生成的 catch 块
		e1.printStackTrace();
	}
	String[] papername = null;
	try {
		papername = teacherInterfaceCao.selectpaper();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	System.out.println(studentclass);
		request.getSession().setAttribute("student_class", studentclass);
		request.getSession().setAttribute("paper_name", papername);
		//重定向
		response.sendRedirect("teacher/checkPaper.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
