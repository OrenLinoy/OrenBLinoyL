package com.myorg.javacourse.model;
/**
 * This class get the stock's portfolio and the title of the portfolio.
 */
public class Portfolio {
	private String title;
	public final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks; 
	private int portfolioSize=0;
	
	public Portfolio(String title){
	   	stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.title=title;
	}
	public Portfolio (Portfolio portfolio){	
		this(portfolio.getTitle());
		for(int i=0; i<portfolio.portfolioSize; i++){
			this.addStock(new Stock(portfolio.getStocks()[i]));
		}		
	}
	public void addStock(Stock stock){
		if (portfolioSize<MAX_PORTFOLIO_SIZE)
			stocks[portfolioSize++]= stock;	
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public Stock[] getStocks() {
		return stocks;
	}
	/**
	 * This method removes the first stock from portfolio. 
	 */
	public void removeFirstStock(){		
		for(int i=1; i<portfolioSize ; i++){
			stocks[i-1]=stocks[i];	
		}
		portfolioSize-=1;
	}
	/**
	 * This method stores the details of the stocks.
	 * @return set
	 */
	public String getHtmlString(){
		String set= "<h1>" + getTitle() + "</h1>";
				
		for (int i=0; i<portfolioSize; i++){
			set+= stocks[i].getHtmlDescription();
		}
		return set;
	}
}