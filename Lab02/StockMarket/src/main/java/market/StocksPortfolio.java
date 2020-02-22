package market;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {
    private String name;
    private IStockMarket marketService;
    private List<Stock> stocks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IStockMarket getMarketService() {
        return marketService;
    }

    public void setMarketService(IStockMarket marketService) {
        this.marketService = marketService;
    }

    public StocksPortfolio(String name) {
        this.name = name;
        this.stocks = new ArrayList<>();
    }

    public double getTotalValue() {
        return this.stocks.stream().mapToDouble(s -> marketService.getPrice(s.getName())*s.getQuantity()).sum();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
}