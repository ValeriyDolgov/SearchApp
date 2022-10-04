package notelastic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StringToQuery {
    public void queryJson(){
        Scanner console = new Scanner(System.in);
        String query = console.nextLine();
        System.out.println("Введите запрос: " + query);
        String readyQuery =
                "{" +
                    "\"query\": {" +
                        "\"match\": {" +
                            "\"annotation\": {" +
                            "\"query\": " + "\"" + query + "\"," +
                            "\"operator\": \"and\"" +
                        "}" +
                    "}" +
                "}" +
                "}";

        try(Writer writer = Files.newBufferedWriter(Paths.get("query.json"))) {
            writer.write(readyQuery);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}