package com.myorg.javacourse.servlet;
import com.myorg.javacourse.service.*;
import com.myorg.javacourse.model.*;

import java.io.IOException;

import javax.servlet.http.*;
/**
 * This class print to the servlet all the portfolios details.
 */
@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio myPortfolio = portfolioManager.getPortfolio();
		resp.getWriter().println(myPortfolio.getHtmlString());
	}
}