package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import caozuo.ManagerInterfaceCao;
import caozuo.ManagerInterfaceImplCao;
import caozuo.TeacherInterfaceCao;
import caozuo.TeacherInterfaceImplCao;
import db.DBUtil;

/**
 * Servlet implementation class teacher_delete
 */
@WebServlet("/teacher_delete")
public class teacher_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        String type=request.getParameter("type");
        ManagerInterfaceCao bc = new ManagerInterfaceImplCao();
        Connection con = DBUtil.getConnection();
        boolean b =false;
        try {
        	
			b=bc.delete(id,con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(b==true) {
        	if(type.equals("3")) {
        	response.sendRedirect("ManagerTeacher");
        }
        	else {
      		 response.sendRedirect("ShowUserInfo?type="+type);  
        	}
        }
        else {
      	  response.sendRedirect("ShowUserInfo?type="+type);
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
