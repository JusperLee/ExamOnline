package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tkt;
import bean.Xzt;
import caozuo.TktInterfaceCao;
import caozuo.TktInterfaceImplCao;
import caozuo.XztInterfaceCao;
import caozuo.XztInterfaceImplCao;

/**
 * Servlet implementation class tktEdit
 */
@WebServlet("/tktEdit")
public class tktEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tktEdit() {
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
			TktInterfaceCao tc =new TktInterfaceImplCao();
			Tkt tkt=new Tkt();
			tkt=tc.select(Integer.parseInt(id));
			request.getSession().setAttribute("tkt_person", tkt);
			response.sendRedirect("Manager/tktEdit.jsp");
		}
		if(type.equals("2")) {
			TktInterfaceCao xc =new TktInterfaceImplCao();
			Tkt tkt=new Tkt();
			System.out.println(Integer.parseInt(id));
			tkt.setId(Integer.parseInt(id));
			boolean b=xc.delete(tkt);
			if(b==true) {
				System.out.println("É¾³ý³É¹¦");
				response.sendRedirect("manage_tkt");
			}
			else {
				System.out.println("É¾³ýÊ§°Ü");
				response.sendRedirect("manage_tkt");
			}
		}
		if(type.equals("3")) {
			TktInterfaceCao xc =new TktInterfaceImplCao();
			String question=request.getParameter("question");
			String answer=request.getParameter("answer");
			Tkt tkt=new Tkt();
			tkt.setId(Integer.parseInt(id));
			tkt.setQuestion(question);
			tkt.setAnswer(answer);
			boolean b=xc.update(tkt);
			if(b==true) {
				request.getSession().setAttribute("tkt_edit", "ÐÞ¸Ä³É¹¦");
				response.sendRedirect("Manager/tktEdit.jsp");
			}
			else {
				request.getSession().setAttribute("tkt_edit", "ÐÞ¸ÄÊ§°Ü");
				response.sendRedirect("Manager/tktEdit.jsp");
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
