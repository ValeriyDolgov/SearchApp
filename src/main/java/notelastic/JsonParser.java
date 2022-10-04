package notelastic;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JsonParser {
    public void parser(String path){
        // Считываем json
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader(path));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
//https://ru.stackoverflow.com/questions/745094/%D0%9A%D0%B0%D0%BA-%D0%B8-%D1%87%D0%B5%D0%BC-%D0%BF%D0%B0%D1%80%D1%81%D0%B8%D1%82%D1%8C-json-%D0%BD%D0%B0-java?ysclid=l8o3tiv2qu406927574
// Кастим obj в JSONObject
        JSONObject jo = (JSONObject) obj;
        JSONObject jo1 = (JSONObject) jo.get("hits");
        JSONArray titleArr = (JSONArray) jo1.get("hits");
        Iterator titleItr = titleArr.iterator();
        System.out.println("_source:");
// Выводим в цикле данные массива
        while (titleItr.hasNext()) {
            JSONObject test = (JSONObject) titleItr.next();
            JSONObject testN = (JSONObject) test.get("_source");
            System.out.println("- title: " + testN.get("title") + ", annotation: " + testN.get("annotation"));
        }
    }
}
