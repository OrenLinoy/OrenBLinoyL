package com.myorg.javacourse.model;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;
/**
 * This class get the stock details.
 */
public class Stock {
	private String symbol;
	private float ask, bid;
	private Date date;
	SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
	private ALGO_RECOMMENDATION recommendation;
	private int quantity;
	
	public Stock(String symbol, float ask, float bid, Date date){
        setSymbol(symbol);
        setAsk(ask);
        setBid(bid);
        setDate(date);
	}
	public Stock(Stock stock){
        this(stock.getSymbol(), stock.getAsk(), stock.getBid(), stock.getDate());	
	}	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public void setDate(Date date) {	
		this.date= date;
	}
	public Date getDate() {
		return date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}
	/**
	 * This method stores the stock details.
	 * @return resultStr
	 */
	public String getHtmlDescription() {		
		String resultStr = new String("<b>Stock symbol</b>:  " + getSymbol() + " <b>Ask</b>:  " + getAsk() + " <b>Bid</b>:  " + getBid() + " <b>Date</b>: " + sdf.format(getDate()) + " <b> Quantity</b>: "+ getQuantity() + "<br>");	
		return resultStr;
	}
}