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
        Double sum = 0.0;
        for (Stock stock : this.stocks) {
            sum += this.marketService.getPrice(stock.getName()) * stock.getQuantity();
        }
        return sum;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

}