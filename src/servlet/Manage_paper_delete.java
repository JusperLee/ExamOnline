package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Paper;
import caozuo.PaperInterfaceCao;
import caozuo.PaperInterfaceImplCao;

/**
 * Servlet implementation class Manage_paper_delete
 */
@WebServlet("/Manage_paper_delete")
public class Manage_paper_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manage_paper_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println(id);
		Paper p=new Paper();
		p.setId(Integer.parseInt(id));
		PaperInterfaceCao pc=new PaperInterfaceImplCao();
		boolean b=pc.delete(p);
		if(b==true) {
			System.out.println("É¾³ý³É¹¦");
			response.sendRedirect("managepaper");
		}
		if(b==false) {
			System.out.println("É¾³ýÊ§°Ü");
			response.sendRedirect("managepaper");
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
