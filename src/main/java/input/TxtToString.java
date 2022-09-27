package input;

import java.io.*;

public class TxtToString {
    public StringBuilder txtReader(String path) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new FileReader(path + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(resultStringBuilder);
        return resultStringBuilder;
    }


}
