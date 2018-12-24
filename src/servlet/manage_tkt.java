package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tkt;
import bean.Tkt;
import caozuo.TktInterfaceCao;
import caozuo.TktInterfaceImplCao;

/**
 * Servlet implementation class manage_tkt
 */
@WebServlet("/manage_tkt")
public class manage_tkt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manage_tkt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tkt> list =new ArrayList();
		TktInterfaceCao tk=new TktInterfaceImplCao();
		list=tk.select();
		request.getSession().setAttribute("TKT", list);
		response.sendRedirect("Manager/manage_tkt.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
