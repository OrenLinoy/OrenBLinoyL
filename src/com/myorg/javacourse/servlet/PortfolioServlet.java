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
		Portfolio portfolio = portfolioManager.getPortfolio();	
		resp.getWriter().println(portfolio.getHtmlString());
		Portfolio portfolio2= new Portfolio(portfolio);
		portfolio2.setTitle("Portfolio #2");
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio.removeFirstStock();
		resp.getWriter().println("<b><h1>After removing the first stock from protfolio Teva: </h1></b>");			
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio2.getStocks()[2].setBid(55.55f);
		resp.getWriter().println("<b><h1>After changing last stock's bid value of portfolio #2:</h1></b>");
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
	}
}