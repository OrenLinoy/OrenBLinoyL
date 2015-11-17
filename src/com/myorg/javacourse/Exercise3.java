package com.myorg.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Exercise3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		MathManager mathManager = new MathManager();
		String resultStr = mathManager.getResults();
		resp.getWriter().println(resultStr);
		
		
	}
}
