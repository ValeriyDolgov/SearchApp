import notelastic.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Choose what you want: 1 - Read file to ElasticSearch, 2 - Create query");
        int num = console.nextInt();
        switch (num) {
            case 1 -> {
                TxtToString txt = new TxtToString();
                txt.txtReader("test");
                txt.txtReader("test2Рус");
            }
            case 2 -> {
                StringToQuery stringToQuery = new StringToQuery();
                stringToQuery.queryJson();
                Get get = new G et();
                get.getMethod();
                Result result = ESApiService.sendSearchRequest(words);
            }
            default -> {
            }
        }
    }
}
