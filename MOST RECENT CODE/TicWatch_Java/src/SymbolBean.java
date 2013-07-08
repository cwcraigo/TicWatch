import java.util.HashMap;

public class SymbolBean {
    
    String name;
    String symbol;
    String price;
    String change;
    String changePercent;
    String open;
    String low;
    String high;
    String market;

    SymbolBean() {
    }

    SymbolBean(HashMap map) {
    	this.name = (String) map.get("name");
    	this.symbol = (String) map.get("symbol");
    	this.price = (String) map.get("price");
    	this.change = (String) map.get("change");
    	this.changePercent = (String) map.get("changePercent");
    	this.open = (String) map.get("open");
    	this.low = (String) map.get("low");
    	this.high = (String) map.get("high");
    	this.market = (String) map.get("market");
    }
    
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSymbol() {
	return symbol;
    }

    public void setSymbol(String symbol) {
	this.symbol = symbol;
    }

    public String getPrice() {
	return price;
    }

    public void setPrice(String price) {
	this.price = price;
    }

    public String getChange() {
	return change;
    }

    public void setChange(String change) {
	this.change = change;
    }

    public String getChangePercent() {
	return changePercent;
    }

    public void setChangePercent(String changePercent) {
	this.changePercent = changePercent;
    }

    public String getOpen() {
	return open;
    }

    public void setOpen(String open) {
	this.open = open;
    }

    public String getLow() {
	return low;
    }

    public void setLow(String low) {
	this.low = low;
    }

    public String getHigh() {
	return high;
    }

    public void setHigh(String high) {
	this.high = high;
    }

    public String getMarket() {
	return market;
    }

    public void setMarket(String market) {
	this.market = market;
    }

    @Override
    public String toString() {
	return "SymbolBean \n[name=\t\t" + name + ", \nsymbol=\t\t" + symbol + ", \nprice=\t\t"
		+ price + ", \nchange=\t\t" + change + ", \nchangePercent=\t"
		+ changePercent + ", \nopen=\t\t" + open + ", \nlow=\t\t" + low + ", \nhigh=\t\t"
		+ high + ", \nmarket=\t\t" + market + "]\n\n";
    }
}
