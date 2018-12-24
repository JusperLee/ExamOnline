package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import servlet.MistakesInterfaceBiz;
import servlet.MistakesInterfaceImplBiz;

/**
 * Servlet implementation class Mistakecollect
 */
@WebServlet("/Mistakecollect")
public class Mistakecollect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mistakecollect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MistakesInterfaceBiz mif=new MistakesInterfaceImplBiz();		
			//将list数据打包
    	Student s=(Student)request.getSession().getAttribute("Student");
		String uname=s.getId();
		System.out.println(uname);
		request.getSession().setAttribute("xztlist", mif.selectxzt(uname));
        
			//request.setAttribute("xztlist", mif.selectxzt(request.getParameter("username")));
		request.getSession().setAttribute("tktlist", mif.selecttkt(uname));
		request.getSession().setAttribute("bctlist", mif.selectbct(uname));
		request.getSession().setAttribute("pdtlist", mif.selectpdt(uname));
		request.getSession().setAttribute("jdtlist", mif.selectjdt(uname));
		//将list数据发送到.jsp文件中
		/*request.getRequestDispatcher("Student/seeFaults.jsp").forward(request, response);*/
			response.sendRedirect("Student/seeFaults.jsp");
			//response.sendRedirect("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
