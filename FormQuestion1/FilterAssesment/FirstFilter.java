package FilterAssesment;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/RequestHandlerServlet")
public class FirstFilter  implements Filter {
	public FirstFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String name1 = request.getParameter("un");
		String name2 = name1.toUpperCase();
		if (name1.equals(name2)) {
			chain.doFilter(request, response);
		} else {
			response.getWriter().write("<h1>invalid username</h1>");
		} 
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("from init of firstfilter");
	}
}
