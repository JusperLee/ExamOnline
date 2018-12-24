package servlet;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Paper;
import caozuo.PaperInterfaceCao;
import caozuo.PaperInterfaceImplCao;

public class Designtest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Designtest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//xzt
		request.setCharacterEncoding("utf-8");
//		String starttime=request.getParameter("starttime");
//		String endtime=request.getParameter("endtime");
		
		SimpleDateFormat strToDate=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Timestamp starttime=Timestamp.valueOf((String) request.getSession().getAttribute("starttime"));
		Timestamp endtime=Timestamp.valueOf((String) request.getSession().getAttribute("endtime"));
		
		String[] str = (String[]) request.getSession().getAttribute("xztids");
		
		System.out.println(starttime);
		String papername = (String)request.getSession().getAttribute("papername");
		System.out.println(papername);
		int[] a = new int[str.length];
		for(int i  = 0; i< str.length ; i++) {
			a[i]=Integer.parseInt(str[i]);
		}
		
	
		//tkt
		
		    String[] str1 = (String[]) request.getSession().getAttribute("tktids");
			int[] b = new int[str1.length];
			for(int i  = 0; i< str1.length ; i++) {
				b[i]=Integer.parseInt(str1[i]);
			}
			
			
			//bct
			
			String[] str2 = (String[]) request.getSession().getAttribute("bctids");
			int[] c = new int[str2.length];
			for(int i  = 0; i< str2.length ; i++) {
				c[i]=Integer.parseInt(str2[i]);

				
			}
			//pdt
			String[] str3 = (String[]) request.getSession().getAttribute("pdtids");
			int[] d = new int[str3.length];
			for(int i = 0; i<str3.length;i++) {
				d[i] = Integer.parseInt(str3[i]);

			}
		//jdt
			String[] str4 = (String[]) request.getSession().getAttribute("jdtids");
			int[] e = new int[str4.length];
			for(int i = 0; i<str4.length;i++) {
				e[i] = Integer.parseInt(str4[i]);
			
			}
			System.out.println(str.length);
			
			System.out.println(str1.length);
			System.out.println(str2.length);
			System.out.println(str3.length);
	//class
			String class1=(String) request.getSession().getAttribute("class1");
			String paperpoint = (String) request.getSession().getAttribute("paperpoint");
			Time time=Time.valueOf((String) request.getSession().getAttribute("time"));
	Paper paper=new Paper(starttime,endtime,papername,a[0],a[1],a[2],a[3],a[4],
			a[5],a[6],a[7],a[8],a[9],b[0],b[1],b[2],b[3],b[4],d[0],d[1],d[2],e[0],e[1],c[0],c[1],class1,paperpoint,time);
	 PaperInterfaceCao p = new PaperInterfaceImplCao();
	 p.insert(paper);
	 response.sendRedirect("teacher/index.jsp");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
