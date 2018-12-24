package servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Paper;

import servlet.PaperInterfaceBiz;
import servlet.PaperInterfaceImplBiz;


/**
 * Servlet implementation class ShowAllPaper
 */
public class ShowAllPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ShowAllPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Paper> lista   = new ArrayList<Paper>();
		List<Paper> listb   = new ArrayList<Paper>();
		List<Paper> listc   = new ArrayList<Paper>();
		lista = null;
		listb = null;
		PaperInterfaceBiz pif= new PaperInterfaceImplBiz();
		String selectpoint = request.getParameter("selectpoint");
			lista = pif.select("java");
			listb = pif.select("C++");
			listc=pif.select();
			request.getSession().setAttribute("java",lista);
			request.getSession().setAttribute("c",listb);
			request.getSession().setAttribute("all",listc);
			//按知识点显示试卷名称等信息
			response.sendRedirect("/web_big_homework/teacher/seePaper.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 全部或按知识点显示试卷，返回paperlist
		 */
		
		
		
		doGet(request, response);
	}

}
