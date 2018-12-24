package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bct;
import bean.Jdt;
import caozuo.BctInterfaceCao;
import caozuo.BctInterfaceImplCao;
import caozuo.JdtInterfaceCao;
import caozuo.JdtInterfaceImplCao;

/**
 * Servlet implementation class bctEdit
 */
@WebServlet("/bctEdit")
public class bctEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bctEdit() {
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
			BctInterfaceCao bc =new BctInterfaceImplCao();
			Bct bct=new Bct();
			bct=bc.select(Integer.parseInt(id));
			request.getSession().setAttribute("bct_person", bct);
			response.sendRedirect("Manager/bctEdit.jsp");
		}
		if(type.equals("2")) {
			BctInterfaceCao bc =new BctInterfaceImplCao();
			Bct bct=new Bct();
			System.out.println(Integer.parseInt(id));
			bct.setId(Integer.parseInt(id));
			boolean b=bc.delete(bct);
			if(b==true) {
				System.out.println("É¾³ý³É¹¦");
				response.sendRedirect("manage_bct");
			}
			else {
				System.out.println("É¾³ýÊ§°Ü");
				response.sendRedirect("manage_bct");
			}
		}
		if(type.equals("3")) {
			BctInterfaceCao bc =new BctInterfaceImplCao();
			String question=request.getParameter("question");
			Bct bct=new Bct();
			bct.setId(Integer.parseInt(id));
			bct.setQuestion(question);
			boolean b=bc.update(bct);
			if(b==true) {
				request.getSession().setAttribute("bct_edit", "ÐÞ¸Ä³É¹¦");
				response.sendRedirect("Manager/bctEdit.jsp");
			}
			else {
				request.getSession().setAttribute("bct_edit", "ÐÞ¸ÄÊ§°Ü");
				response.sendRedirect("Manager/bctEdit.jsp");
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
