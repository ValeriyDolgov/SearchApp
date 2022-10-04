package notelastic;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Post {
    public void postMethod(String fileName, String txt){
        String uri = "http://localhost:9200/test_index/_doc/";
        HttpRequest req = null;
        String createQuery = "{\n"+
                " \"title\": \"" + fileName + "\",\n" +
                " \"annotation\":\"" + /**StringEscapeUtils.escapeJson(txt)**/JSONObject.escape(txt) + "\"\n" +
                "}\n";
        req = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(createQuery))
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpClient client = HttpClient.newBuilder()
                .build();
        try {
            HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
//            System.out.println(resp.statusCode());
//            System.out.println(resp.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}