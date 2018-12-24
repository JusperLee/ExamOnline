package regist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class regist_student
 */
@WebServlet("/regist_student")
public class regist_student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regist_student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    PreparedStatement ps = null;
	    DataSource ds = null;
        try {
        	    Context initCtx = new InitialContext();
                Context envCtx = (Context)initCtx.lookup("java:comp/env");
                ds = (DataSource) envCtx.lookup("tomcatpool");    
        	    Connection conn= ds.getConnection();
        	    System.out.println("success");
        		String stu_name=request.getParameter("name");
        		String stu_class = request.getParameter("class");
        		String stu_number = request.getParameter("number");
        		int stu_pre=1;
        		System.out.println(stu_name);
        		String stu_tel = request.getParameter("tel_num2");
        		String stu_password=request.getParameter("password");
        		String yan=request.getParameter("yan");
        		String yan1=(String) request.getSession().getAttribute("yan1");
        		if(yan.equals(yan1)) {
        			String sql = "INSERT INTO student_info VALUES (?,AES_ENCRYPT(?,'dimtim'),"
        					+ "AES_ENCRYPT(?,'dimtim'),?,AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'))";
        		ps=conn.prepareStatement(sql);
        		ps.setString(1, stu_name);
        		ps.setString(2, stu_class);
        		ps.setString(3, stu_number);
        		ps.setInt(4, stu_pre);
        		ps.setString(5, stu_tel);
        		ps.setString(6, stu_password);
        		int i=ps.executeUpdate();
        		
        		if(ps!=null) {
        			ps.close();
        		}
        		if(conn!=null) {
        			conn.close();
        		}
        		if(i == 1) {
        			System.out.println("³É¹¦");
        			response.sendRedirect("/web_big_homework/register_success.jsp");
        		}
        	}
       		if(yan!=yan1) {
        			response.sendRedirect("/web_big_homework/register_student.jsp");
        		}
        		}catch(Exception ex) {
        		ex.printStackTrace();
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
