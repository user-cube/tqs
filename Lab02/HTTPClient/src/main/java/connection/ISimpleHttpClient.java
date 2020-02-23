package connection;

import java.io.IOException;

public interface ISimpleHttpClient {

    String get(String url) throws IOException;
}
