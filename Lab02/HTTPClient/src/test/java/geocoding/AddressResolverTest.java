package geocoding;

import connection.TqsHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileReader;
import java.net.URISyntaxException;


@ExtendWith(MockitoExtension.class)
public class AddressResolverTest {
    @Mock
    private TqsHttpClient tqsHttpClient;

    @Test
    public void findAddressForLocation() throws URISyntaxException, ParseException {
        String simpleURL = "http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.633331%2C-8.659713&includeRoadMetadata=true";
        JSONObject jsonObject = null;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/java/geocoding/simpleJSON.json"));
            jsonObject = (JSONObject) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.when(tqsHttpClient.get(simpleURL)).thenReturn(jsonObject.toString());
        AddressResolver resolver = new AddressResolver(tqsHttpClient);
        Address result = resolver.findAddressForLocation(40.6333308, -8.659713);

        Assert.assertEquals(result,
                new Address(null,
                        "DETI - Departamento de Electrónica, Telecomunicações e Informática",
                        "Glória e Vera Cruz",
                        "Centro",
                        "3810-193")
        );
    }
}