package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentGrade;
import caozuo.StudentGradeInterfaceCao;
import caozuo.StudentGradeInterfaceImplCao;
import caozuo.TeacherInterfaceCao;
import caozuo.TeacherInterfaceImplCao;



public class ShowStudentGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentGrade() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherInterfaceCao teacherInterfaceCao = new TeacherInterfaceImplCao();
		String class1=request.getParameter("class");
		String paper_name=request.getParameter("papername");
		String type=request.getParameter("type");
		System.out.println("type="+type);
		String[] studentclass = null;
		StudentGradeInterfaceCao sgc=new StudentGradeInterfaceImplCao();
		if(Integer.parseInt(type)==1) {
			List<StudentGrade> list=new ArrayList<StudentGrade>();
			list=sgc.select(class1, paper_name);
			request.getSession().setAttribute("StudentGrade", list);
		}
		
		try {
			studentclass = teacherInterfaceCao.selectclass();
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		String[] papername = null;
		try {
			papername = teacherInterfaceCao.selectpaper();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			
			request.getSession().setAttribute("studentclass", studentclass);
			request.getSession().setAttribute("papername", papername);
		//����Ҫ��service���װ
		
	
		response.sendRedirect("teacher/checkExamResult.jsp");
		
	}

}
