package notelastic;

import notelastic.Post;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TxtToString {
    public void txtReader(String path) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new FileReader(path + ".txt", StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String base = resultStringBuilder.toString();
        Post post = new Post();
        post.postMethod(path, base);
    }


}
