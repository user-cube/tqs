package market;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class IStockMarketTest {
    @Mock
    private IStockMarket market;
    @InjectMocks
    StocksPortfolio stocksPortfolio;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void getPrice() {
    }
}