package FilterAssesment;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

@WebFilter("/RequestHandlerServlet")

public class SecondFilter  implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("From init of Second filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request.getParameter("pwd").equals("1234")) {
			chain.doFilter(request, response);
		} else {
			response.getWriter().write("<h1>Invalid Password</h1>");
		}
	}

	public void destroy() {
	}

}

