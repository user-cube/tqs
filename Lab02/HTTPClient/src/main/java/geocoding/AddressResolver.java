package geocoding;
import connection.TqsHttpClient;

import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Formatter;
import java.util.Locale;

public class AddressResolver {
    private TqsHttpClient httpClient;

    public AddressResolver(TqsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Address findAddressForLocation(double latitude, double longitude) throws URISyntaxException, IOException, org.json.simple.parser.ParseException {
        URIBuilder uriBuilder = new URIBuilder(
                "http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location",
                (new Formatter()).format(Locale.US,
                        "%.6f,%.6f",
                        latitude,
                        longitude).toString());
        uriBuilder.addParameter("includeRoadMetadata", "true");

        // System.err.println(" url is --> " + uriBuilder.build().toString());

        String response = this.httpClient.get(uriBuilder.build().toString());

        // get parts from response till reaching the address
        JSONObject obj = (JSONObject) new JSONParser().parse(response);
        obj = (JSONObject) ((JSONArray) obj.get("results")).get(0);
        JSONObject address = (JSONObject) ((JSONArray) obj.get("locations")).get(0);

        String road  = (String) address.get("street");
        String city  = (String) address.get("adminArea5");
        String state = (String) address.get("adminArea3");
        String zip   = (String) address.get("postalCode");
        return new Address(null, road, city, state, zip);
    }
}
