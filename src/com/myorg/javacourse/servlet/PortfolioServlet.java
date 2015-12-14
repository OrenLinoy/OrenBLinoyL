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
		myPortfolio.setBalance(10000);
		resp.getWriter().println(myPortfolio.getHtmlString());

		resp.getWriter().println("<b><h1><u>After buying stocks:</u></b></h1>");
		myPortfolio.buyStock(myPortfolio.getStocks()[0], 20);
		myPortfolio.buyStock(myPortfolio.getStocks()[1], 30);
		myPortfolio.buyStock(myPortfolio.getStocks()[2], 40);
		resp.getWriter().println(myPortfolio.getHtmlString());
		
		resp.getWriter().println("<b><h1><u>After selling stock 'AAL':</u></b></h1>");
		myPortfolio.sellStock("AAL", -1);
		resp.getWriter().println(myPortfolio.getHtmlString());
		
		resp.getWriter().println("<b><h1><u>After remove stock 'CAAS':</u></b></h1>");
		myPortfolio.removeStock("CAAS");
		resp.getWriter().println(myPortfolio.getHtmlString());	
	}
}