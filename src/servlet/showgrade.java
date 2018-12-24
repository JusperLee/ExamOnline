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
import bean.StudentGrade;
import caozuo.StudentGradeInterfaceCao;
import caozuo.StudentGradeInterfaceImplCao;
import caozuo.StudentInterfaceCao;
import caozuo.StudentInterfaceImplCao;

/**
 * Servlet implementation class showgrade
 */
@WebServlet("/showgrade")
public class showgrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showgrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("stu_id");
		String papername=request.getParameter("papername");
		StudentGradeInterfaceCao sgc=new StudentGradeInterfaceImplCao();
		List<StudentGrade> list=new ArrayList<StudentGrade>();
		Student s=null;
		StudentInterfaceCao sc=new StudentInterfaceImplCao();
		try {
			s=sc.showuserinfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list = sgc.select(s.getStudentclass(), papername);
		StudentGrade sg=null;
		System.out.println(list);
		request.getSession().setAttribute("person_grade", list.get(0));
		response.sendRedirect("teacher/show_person.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
