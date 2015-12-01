package com.myorg.javacourse.model;

import com.myorg.javacourse.Stock;

public class Portfolio {
	private String title;
	public final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize=0;
	
	public Portfolio(){
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
	public void addStock(Stock stock){
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

	public String getHtmlString(){
		String set= "<h1>" + getTitle() + "</h1>";
				
		for (int i=0; i<portfolioSize; i++){
			set+= stocks[i].getHtmlDescription() + "<br>";
		}
		return set;
	}
	
}
