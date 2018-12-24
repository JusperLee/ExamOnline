package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Paper;
import bean.Xzt;
import caozuo.PaperInterfaceCao;
import caozuo.PaperInterfaceImplCao;
import caozuo.XztInterfaceCao;
import caozuo.XztInterfaceImplCao;

/**
 * Servlet implementation class xztedit
 */
@WebServlet("/xztedit")
public class xztedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xztedit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		if(type.equals("1")) {
			XztInterfaceCao xc =new XztInterfaceImplCao();
			Xzt xzt=new Xzt();
			xzt=xc.select(Integer.parseInt(id));
			request.getSession().setAttribute("xzt_person", xzt);
			response.sendRedirect("Manager/xztEdit.jsp");
		}
		if(type.equals("2")) {
			XztInterfaceCao xc =new XztInterfaceImplCao();
			Xzt xzt=new Xzt();
			xzt.setId(Integer.parseInt(id));
			boolean b=xc.delete(xzt);
			if(b==true) {
				System.out.println("É¾³ý³É¹¦");
				response.sendRedirect("manage_xzt");
			}
			else {
				System.out.println("É¾³ýÊ§°Ü");
				response.sendRedirect("manage_xzt");
			}
		}
		if(type.equals("3")) {
			XztInterfaceCao xc =new XztInterfaceImplCao();
			String question=request.getParameter("question");
			String answer=request.getParameter("answer");
			String optionA=request.getParameter("optionA");
			String optionB=request.getParameter("optionB");
			String optionC=request.getParameter("optionC");
			String optionD=request.getParameter("optionD");
			Xzt xzt=new Xzt();
			xzt.setId(Integer.parseInt(id));
			xzt.setQuestion(question);
			xzt.setAnswer(answer);
			xzt.setOptionA(optionA);
			xzt.setOptionB(optionB);
			xzt.setOptionC(optionC);
			xzt.setOptionD(optionD);
			boolean b=xc.update(xzt);
			if(b==true) {
				request.getSession().setAttribute("xzt_edit", "ÐÞ¸Ä³É¹¦");
				response.sendRedirect("Manager/xztEdit.jsp");
			}
			else {
				request.getSession().setAttribute("xzt_edit", "ÐÞ¸ÄÊ§°Ü");
				response.sendRedirect("Manager/xztEdit.jsp");
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
