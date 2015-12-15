package com.myorg.javacourse.service;
import java.util.Date;
import com.myorg.javacourse.model.*;
/**
 * This class stores the stock's portfolio details.
 */
public class PortfolioManager {
	/**
	 * This method sets the stock's portfolio details.
	 * @return portfolio
	 */
	@SuppressWarnings("deprecation")
	public Portfolio getPortfolio(){
		
		Portfolio myPortfolio= new Portfolio("Exercise 7 portfolio");
		myPortfolio.setBalance(10000);
		
		Stock stock1 = new Stock("PIH",10.0f,8.5f,new Date("12/15/2014"));
		myPortfolio.addStock(stock1);
		
		Stock stock2 = new Stock(stock1);
		stock2.setSymbol("AAL");
		stock2.setAsk(30.0f);
		stock2.setBid(25.5f);
		myPortfolio.addStock(stock2);
		
		Stock stock3 = new Stock(stock1);
		stock3.setSymbol("CAAS");
		stock3.setAsk(20.0f);
		stock3.setBid(15.5f);
		myPortfolio.addStock(stock3);

		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);		
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		return myPortfolio;
	}
}