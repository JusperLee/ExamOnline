package regist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class regist_teacher
 */
@WebServlet("/regist_teacher")
public class regist_teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regist_teacher() {
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
        		String tea_name=request.getParameter("name");
        		int tea_pre=2;
        		System.out.println(tea_name);
        		String tea_tel = request.getParameter("tel_num2");
        		String tea_password=request.getParameter("password");
        		String tea_auth=request.getParameter("auth");
        		String tea_num=request.getParameter("num");
        		String yan=request.getParameter("yan");
        		String yan1=(String) request.getSession().getAttribute("yan1");
        		if(yan.equals(yan1)) {
        			String sql = "INSERT INTO teacher_info VALUES (?,?,AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'))";
            		ps=conn.prepareStatement(sql);
            		ps.setString(1, tea_name);
            		ps.setInt(2, tea_pre);
            		ps.setString(3, tea_auth);
            		ps.setString(4, tea_tel);
            		ps.setString(5, tea_password);
            		ps.setString(6, tea_num);
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
        		}
        		catch(Exception ex) {
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
