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
import bean.Manager;

public class ManagerFilter implements Filter {

    public ManagerFilter() {
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
		Manager s = (Manager) session.getAttribute("Manager");
		if(s == null){
			
			response.sendRedirect("../login.jsp");
			return;
		}
		String username=s.getId();
		int rule=s.getRu();	
		if ( rule != 3 || "".equals(username)) {
		
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
