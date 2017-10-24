import java.io.*;
import java.util.*;

public class CsvSum{

static Map<String, Integer> map = new HashMap<String, Integer>();

public static void main(String args[]) throws Exception{
    File file = new File("test.csv");
    Scanner scanner = new Scanner(file);
    while(scanner.hasNext()){
        String line = scanner.next();
        String[] columns = line.split(";");

        String date = columns[0].replace("DATE=","");
        String id = columns[1].replace("ID=","");
        int avg = Integer.parseInt(columns[2].replace("AVG=",""));

        String key = date + "_" +id;
        if(!map.containsKey(key)){
            map.put(key,avg);
        }else{
            Integer existing = map.get(key);
            map.put(key, existing + avg);
        }
    }

    System.out.println(map);
}
}