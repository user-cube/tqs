package connection;

import java.io.IOException;

public interface TqsHttpClient {
    String get(String uri) throws IOException;
}