package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import caozuo.PaperInterfaceCao;
import caozuo.PaperInterfaceImplCao;




public class ShowPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowPaper() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaperInterfaceCao pif=new PaperInterfaceImplCao();
		System.out.println(">>>>>><<<<<>>>>>>>");
		
		Student s =(Student)request.getSession().getAttribute("Student");
		System.out.println(s.getId());
		request.getSession().setAttribute("PaperBefore",pif.showbeforePaper(s.getId()));
		request.getSession().setAttribute("PaperAfter",pif.showafterPaper(s.getId()));
		request.getSession().setAttribute("PaperNow",pif.shownowPaper(s.getId()));

		//Ìø×ªµ½ÊÔ¾íÒ³
		response.sendRedirect("Student/NowExam.jsp");
		//request.getRequestDispatcher("student/showExam.jsp").forward(request, response);
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
