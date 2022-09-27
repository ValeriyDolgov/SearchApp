package input;

import com.sun.net.httpserver.Headers;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.net.URI;

public class Root {
    public String title;
    public String annotation;

    public static void createAlias(RestClient client, String alias, String index) throws Exception {

        assert client != null;
        assert alias != null;
        assert index != null;

        Request request = new Request("POST", "/_aliases/");
        request.setJsonEntity("{\"actions\":[{\"add\":{\"index\":\"" + index +"\",\"alias\":\"" + alias +"\"}}]}");
        Response response = client.performRequest(request);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new Exception("Could not create alias ["+alias+"] on index ["+index+"].");
        }
    }
}


