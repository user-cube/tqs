package market;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IStockMarketTest {

    @Mock private IStockMarket market;
    @InjectMocks private StocksPortfolio stocksPortfolio;

    @BeforeEach
    public void setUp(){
        stocksPortfolio = new StocksPortfolio("potato");
        stocksPortfolio.setMarketService(market);
    }

    @Test
    public void testTotalValue() {
        when(market.getPrice("EBAY")).thenReturn(41.0);
        Stock ebayStock = new Stock("EBAY", 2);
        stocksPortfolio.addStock(ebayStock);
        assertEquals(82, stocksPortfolio.getTotalValue(), 0.001);
    }
}