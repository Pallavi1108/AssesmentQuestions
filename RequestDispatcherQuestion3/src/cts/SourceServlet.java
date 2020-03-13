package cts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

@WebServlet("/SourceServlet")
public class SourceServlet  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("From doGet of source Servlet");
		String custName = req.getParameter("customerName");
		int term = Integer.parseInt(req.getParameter("term"));
		int premium = Integer.parseInt(req.getParameter("premium"));

		req.setAttribute("customerName", custName);
		req.setAttribute("noOfYears", term);
		req.setAttribute("amount", premium);
		System.out.println("Your Paid Amount== " + (premium * term));
		PrintWriter pw = resp.getWriter();
		pw.write("<h1> Your paid amount is: "+(premium * term)+"</h1>");
	RequestDispatcher dispatvher= req.getRequestDispatcher("/TargetServlet");

	//	RequestDispatcher dispatvher= req.getRequestDispatcher("/http://localhost:8080/Web_Application-2/Form.html");
		//dispatvher.include(req, resp);
		//resp.sendRedirect("http://localhost:8080/Web_Application-2/Form.html");
	}
}

