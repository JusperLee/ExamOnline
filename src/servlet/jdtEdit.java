package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Jdt;
import bean.Pdt;
import caozuo.JdtInterfaceCao;
import caozuo.JdtInterfaceImplCao;
import caozuo.PdtInterfaceCao;
import caozuo.PdtInterfaceImplCao;

/**
 * Servlet implementation class jdtEdit
 */
@WebServlet("/jdtEdit")
public class jdtEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jdtEdit() {
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
			JdtInterfaceCao jc =new JdtInterfaceImplCao();
			Jdt jdt=new Jdt();
			jdt=jc.select(Integer.parseInt(id));
			request.getSession().setAttribute("jdt_person", jdt);
			response.sendRedirect("Manager/jdtEdit.jsp");
		}
		if(type.equals("2")) {
			JdtInterfaceCao pc =new JdtInterfaceImplCao();
			Jdt jdt=new Jdt();
			System.out.println(Integer.parseInt(id));
			jdt.setId(Integer.parseInt(id));
			boolean b=pc.delete(jdt);
			if(b==true) {
				System.out.println("É¾³ý³É¹¦");
				response.sendRedirect("manage_jdt");
			}
			else {
				System.out.println("É¾³ýÊ§°Ü");
				response.sendRedirect("manage_jdt");
			}
		}
		if(type.equals("3")) {
			JdtInterfaceCao xc =new JdtInterfaceImplCao();
			String question=request.getParameter("question");
			Jdt jdt=new Jdt();
			jdt.setId(Integer.parseInt(id));
			jdt.setQuestion(question);
			boolean b=xc.update(jdt);
			if(b==true) {
				request.getSession().setAttribute("jdt_edit", "ÐÞ¸Ä³É¹¦");
				response.sendRedirect("Manager/jdtEdit.jsp");
			}
			else {
				request.getSession().setAttribute("pdt_edit", "ÐÞ¸ÄÊ§°Ü");
				response.sendRedirect("Manager/pdtEdit.jsp");
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
