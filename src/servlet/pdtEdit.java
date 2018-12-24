package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pdt;
import bean.Tkt;
import caozuo.PdtInterfaceCao;
import caozuo.PdtInterfaceImplCao;
import caozuo.TktInterfaceCao;
import caozuo.TktInterfaceImplCao;

/**
 * Servlet implementation class pdtEdit
 */
@WebServlet("/pdtEdit")
public class pdtEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdtEdit() {
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
			PdtInterfaceCao pc =new PdtInterfaceImplCao();
			Pdt pdt=new Pdt();
			pdt=pc.select(Integer.parseInt(id));
			request.getSession().setAttribute("pdt_person", pdt);
			response.sendRedirect("Manager/pdtEdit.jsp");
		}
		if(type.equals("2")) {
			PdtInterfaceCao pc =new PdtInterfaceImplCao();
			Pdt pdt=new Pdt();
			System.out.println(Integer.parseInt(id));
			pdt.setId(Integer.parseInt(id));
			boolean b=pc.delete(pdt);
			if(b==true) {
				System.out.println("É¾³ý³É¹¦");
				response.sendRedirect("manage_pdt");
			}
			else {
				System.out.println("É¾³ýÊ§°Ü");
				response.sendRedirect("manage_pdt");
			}
		}
		if(type.equals("3")) {
			PdtInterfaceCao xc =new PdtInterfaceImplCao();
			String question=request.getParameter("question");
			String answer=request.getParameter("answer");
			Pdt pdt=new Pdt();
			pdt.setId(Integer.parseInt(id));
			pdt.setQuestion(question);
			pdt.setAnswer(answer);
			boolean b=xc.update(pdt);
			if(b==true) {
				request.getSession().setAttribute("pdt_edit", "ÐÞ¸Ä³É¹¦");
				response.sendRedirect("Manager/pdtEdit.jsp");
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
