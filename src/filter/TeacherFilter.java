package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.Teacher;

public class TeacherFilter implements Filter {

    public TeacherFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		System.out.println("管理员过滤器停止工作");
	}


	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		Teacher t = (Teacher) session.getAttribute("Teacher");
		if(t == null){
			System.out.println("nullllllllllllllllllll");
			response.sendRedirect("../login.jsp");
			return;
		}
		String username=t.getId();
		int rule=t.getRu();	
		if ( rule != 2 || "".equals(username)) {
		
			 response.sendRedirect("../login.jsp");
		}
		else
		  {
			chain.doFilter(request, response);		    
		  }
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("管理员过滤器开始工作");
	}

}
