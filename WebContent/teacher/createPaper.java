package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bct;
import bean.Jdt;
import bean.Pdt;
import bean.Tkt;
import bean.Xzt;
import caozuo.BctInterfaceCao;
import caozuo.BctInterfaceImplCao;
import caozuo.JdtInterfaceCao;
import caozuo.JdtInterfaceImplCao;
import caozuo.PdtInterfaceCao;
import caozuo.PdtInterfaceImplCao;
import caozuo.TktInterfaceCao;
import caozuo.TktInterfaceImplCao;
import caozuo.XztInterfaceCao;
import caozuo.XztInterfaceImplCao;
/**
 * Servlet implementation class createPaper
 */
@WebServlet("/createPaper")
public class createPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		XztInterfaceCao xf = new XztInterfaceImplCao();
		List<Xzt> xzt = new ArrayList<Xzt>();
		xzt= xf.select();
		request.getSession().setAttribute("xztlist", xf.select());
		TktInterfaceCao tf = new TktInterfaceImplCao();
		List<Tkt> tkt = new ArrayList<Tkt>();
		tkt= tf.select();
		request.getSession().setAttribute("tktlist", tkt);
		BctInterfaceCao cf=new BctInterfaceImplCao();
		List<Bct> bct=new ArrayList<Bct>();
		bct=cf.select();
		request.getSession().setAttribute("bctlist", bct);
		JdtInterfaceCao jd=new JdtInterfaceImplCao();
		List<Jdt> jdt=new ArrayList<Jdt>();
		jdt=jd.select();
		request.getSession().setAttribute("jdtlist", jdt);
		PdtInterfaceCao pd=new PdtInterfaceImplCao();
		List<Pdt> pdt=new ArrayList<Pdt>();
		pdt=pd.select();
		request.getSession().setAttribute("pdtlist", pdt);
		System.out.println(xzt);
	   response.sendRedirect("teacher/createPaper0.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		doGet(request, response);
	}

}
