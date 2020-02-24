package geocoding;

import connection.TqsBasicClient;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class AddressResolverIT {

    @Test
    public void whenGoodCoordidates_returnAddress() throws URISyntaxException, ParseException, IOException {
        AddressResolver resolver =new AddressResolver( new TqsBasicClient());
        Address result = resolver.findAddressForLocation( 40.6406609,-8.6566883);
        Assert.assertEquals( result , new Address( null, "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246") );
    }

    @Test
    public void whenBadCoordidates_trhowBadArrayindex(){
        AddressResolver resolver =new AddressResolver( new TqsBasicClient());
        assertThrows(NullPointerException.class, () -> resolver.findAddressForLocation(40.6333310, -8.65971));
    }
}