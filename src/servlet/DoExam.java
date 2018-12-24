package servlet;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Paper;
import bean.PaperString;
import servlet.PaperInterfaceBiz;
import servlet.PaperInterfaceImplBiz;
import tool.QuestionInstance;



public class DoExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String papername=request.getParameter("papername");
		System.out.println(papername);
		PaperInterfaceBiz pf=new PaperInterfaceImplBiz();
		Paper p=pf.selectInstance(papername);
		PaperString ps=QuestionInstance.changeToPaperString(p);
		//把ps转发回考页面显示，进行考试
		request.getSession().setAttribute("ps", ps);
		//重定向	
		//request.getRequestDispatcher("paperXzTk.jsp").forward(request, response);
		Time time=ps.getTime();
		System.out.println(time);
		@SuppressWarnings("deprecation")
		int hours=time.getHours();
		@SuppressWarnings("deprecation")
		int minutes=time.getMinutes();
		@SuppressWarnings("deprecation")
		int seconds=time.getSeconds();
		String s=String.valueOf(hours*60+minutes*60+seconds);
		System.out.println("time=="+s);
		request.getSession().setAttribute("time", s);
		request.getRequestDispatcher("Student/exam_paper.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
