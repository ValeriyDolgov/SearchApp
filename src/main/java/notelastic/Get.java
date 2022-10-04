package notelastic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Get {
    public void getMethod(){
        String uri = "http://localhost:9200/_search";
        HttpRequest req = null;
        try {
            req = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("query.json")))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpClient client = HttpClient.newBuilder()
                .build();
        try {
            HttpResponse<Path> resp = client.send(req, HttpResponse.BodyHandlers.ofFile(Paths.get("query1.json")));
            System.out.println(resp.statusCode());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonParser jsonParser = new JsonParser();
        jsonParser.parser("query1.json");
    }
}