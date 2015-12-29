package com.myorg.javacourse.model;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.algo.model.StockInterface;

import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;
/**
 * This class get the stock details.
 */
public class Stock implements StockInterface{
	private String symbol;
	private float ask, bid;
	private Date date;
	private long time;
	private ALGO_RECOMMENDATION recommendation;
	private int quantity;
	
	public Stock(){
		this.symbol=null;
        this.ask=0;
        this.bid=0;
        this.date=null;
        this.quantity=0;
	}
	
	public Stock(String symbol, float ask, float bid, Date date, int quantity){
        this.symbol=symbol;
        this.ask=ask;
        this.bid=bid;
        this.date=date;
        this.quantity=quantity;
	}
	public Stock(Stock stock){
        this(stock.getSymbol(), stock.getAsk(), stock.getBid(), stock.getDate(),stock.getQuantity());      
        this.recommendation= stock.getRecommendation();
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getTime() {
		return time;
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
	public void setDate(long time) {	
		this.date= new Date(time);
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
		SimpleDateFormat  sdf= new SimpleDateFormat("MM/dd/yyyy");
		String resultStr = new String("<b>Stock symbol</b>:  " + getSymbol() + " <b>Ask</b>:  " + getAsk() + " <b>Bid</b>:  " + getBid() + " <b>Date</b>: " + sdf.format(getDate()) + " <b> Quantity</b>: "+ getQuantity() + "<br>");	
		return resultStr;
	}
}