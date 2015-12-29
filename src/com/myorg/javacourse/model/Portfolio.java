package com.myorg.javacourse.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;
/**
 * This class get the stock's portfolio and the title of the portfolio.
 */
public class Portfolio implements PortfolioInterface {
	public final static int MAX_PORTFOLIO_SIZE = 100;
	private String title;
	private StockInterface[] stocks; 
	private int portfolioSize=0;
	private float balance;
	public enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};
	
	public Portfolio(){
		stocks = new Stock[MAX_PORTFOLIO_SIZE];	 
	}
	public Portfolio(Stock[] stockArray) {
		this();
		for (int i=0; i< stockArray.length; i++){
			this.stocks[i]=stockArray[i];
		}
		portfolioSize=stockArray.length;
	}
	/*public Portfolio (Portfolio portfolio){	
		this();
		for(int i=0; i<portfolio.portfolioSize; i++){
			this.addStock(new Stock(portfolio.getStocks()[i]));
		}	
		
	}*/
	
	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public Stock[] getStocks() {
		return (Stock[]) stocks;
	}
	public int getPortfolioSize() {
		return portfolioSize;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	/**
	 * this method add stock to the portfolio.
	 * @param stock
	 */
	public void addStock(Stock stock){
		boolean flag=true;
		for(int i=0;i<portfolioSize && flag;i++){
			if(stocks[i].getSymbol().equals(stock.getSymbol())){
				flag=false;
			}
		}		
		if (portfolioSize<MAX_PORTFOLIO_SIZE && flag){
			stock.setQuantity(0);
			stocks[portfolioSize++]= stock;	
		}
		else if (portfolioSize>=MAX_PORTFOLIO_SIZE)
			System.out.println("Can’t add new stock, portfolio can have only "+ MAX_PORTFOLIO_SIZE + " stocks");
		else
			System.out.println("This stock is already exist in the portfolio.");
	}
	/**
	 * This method updates the money available in the portfolio.
	 * @param amount
	 */
	public void updateBalance(float amount){
		if (amount+balance<0)
			System.out.println("The balance can't be negative.");
		else
			balance+=amount;	
	}	
	/**
	 * This method removes stock from portfolio. 
	 * @param symbol
	 *@return true/false if it successed or failed.
	 */
	public boolean removeStock(String symbol){	
		for(int i=0; i<portfolioSize ; i++){
			if (stocks[i].getSymbol().equals(symbol)){
				if (sellStock(symbol,((Stock) stocks[i]).getQuantity())){
					if (i+1==portfolioSize){
						stocks[i]=null;
					}
					else{
						for (int j=i; j<portfolioSize;j++){
							stocks[j]=stocks[j+1];				
						}
					}
					portfolioSize-=1;
					return true;					
				}
			}					
		}
		return false;
	}
	/**
	 * This method selling a stock from the portfolio.
	 * @param 
	 * @return true/false if it successed or failed.
	 */
	public boolean sellStock(String symbol, int quantity){
		for(int i=0; i<portfolioSize && quantity>-2; i++){
			if (stocks[i].getSymbol().equals(symbol)){
				if(quantity==-1){
					updateBalance(stocks[i].getBid()*((Stock) stocks[i]).getQuantity());
					((Stock) stocks[i]).setQuantity(0);
					return true;
				}
				else if (((Stock) stocks[i]).getQuantity()>=quantity){
					updateBalance(stocks[i].getBid()*quantity);
					((Stock) stocks[i]).setQuantity(((Stock) stocks[i]).getQuantity()-quantity);
					return true;
				}
				else{
					System.out.println("Not enough stocks to sell");
					return false;
				}
			}	
		}
		return false;
	}	
	/**
	 * This method buying stock and add it to the portfolio if the stock doesn't exist.
	 * @param
	 * @return true/false if it successed or failed
	 */
	public boolean buyStock(Stock stock, int quantity){
		for (int i=0; i<portfolioSize && quantity>-2 && quantity!=0 ;i++){
			if (stocks[i].getSymbol().equals(stock.getSymbol())){
				if(quantity==-1 && (balance/stock.getAsk())>=1 && ((balance/stock.getAsk())*stock.getAsk())<=balance){
					((Stock) stocks[i]).setQuantity(stock.getQuantity()+(int)(balance/stock.getAsk()));
					updateBalance((balance%stock.getAsk())-balance);
					return true;
				}
				else if ((balance/stock.getAsk())>=1 && (quantity*stock.getAsk())<=balance){
					((Stock) stocks[i]).setQuantity(stock.getQuantity()+quantity);
					updateBalance((balance-(quantity*stock.getAsk()))-balance);
					return true;
				}
				else{
					System.out.println("Not enough balance to complete purchase.");
					return false;
				}
			}
		}
		if(quantity==-1 && balance/stock.getAsk()>=1 && (balance/stock.getAsk())*stock.getAsk()<=balance){
			addStock(stock);
			stock.setQuantity(stock.getQuantity()+(int)(balance/stock.getAsk()));
			updateBalance((balance%stock.getAsk())-balance);
			return true;
		}
		else if (balance/stock.getAsk()>=1 && quantity*stock.getAsk()<=balance){
			addStock(stock);
			stock.setQuantity(stock.getQuantity()+quantity);
			updateBalance((balance-(quantity*stock.getAsk()))-balance);
			return true;
		}
		else if (quantity>-2 && quantity!=0){
			System.out.println("Not enough balance to complete purchase.");
			return false;
		}
		return false;
	}
	/**
	 * This method returns all stocks value in the portfolio.
	 * @return stocksValue
	 */
	public double getStocksValue(){
		double stocksValue=0;
		for(int i=0; i<portfolioSize; i++){
			stocksValue+=stocks[i].getBid()*((Stock) stocks[i]).getQuantity();
		}
		return stocksValue;		
	}
	/**
	 *This method returns the total value of the portfolio.
	 */
	public double getTotalValue(){
		return getStocksValue()+getBalance();
	}
	/**
	 * This method stores the details of the stocks.
	 * @return set
	 */
	public String getHtmlString(){
		String set = ("<h1>" + getTitle()+  "</h1>");	
		for(int i=0;i<portfolioSize;i++){
			set =set + ((Stock) stocks[i]).getHtmlDescription()+ "<br>";
		}
		set+="<b>Total portfolio value: </b>" + getTotalValue() + "<b>$ , Total stocks value: </b>" + getStocksValue()+ "<b>$ , Balance: </b>" + getBalance() + "$"; 
		return set; 
	}
	public StockInterface findStock(String symbol) {
		for (int i=0; i<portfolioSize; i++){
			if (getStocks()[i].getSymbol().equals(symbol)){
				return getStocks()[i];
			}
		}
		return null;
	}
}