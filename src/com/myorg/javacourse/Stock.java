package com.myorg.javacourse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	private String symbol;
	private float ask, bid;
	private Date date;
	SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
	private int recommendation;
	private int stockQuantity;
	public final static int BUY=0, SELL=1, REMOVE=2, HOLD=3; 
	
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
	public String getHtmlDescription() {
		
		String resultStr = new String("<b>Stock symbol</b>:  " + getSymbol() + " <b>Ask</b>:  " + getAsk() + " <b>Bid</b>:  " + getBid() + " <b>Date</b>: " + sdf.format(getDate()) + "<br>");	
		return resultStr;
	}
	
	
	

}