import java.io.*;
import java.util.*;
import java.nio.file.*
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
  }
  public void topk(String file ,int k)
  {
      
      HashMap map<Integer> map = new HashMap<>();
      InputStream is = new FileInputStream(file);
     BufferReader reader = new BufferedReader(new InputStream(is));
             
        String currentLine = reader.readLine();
             
            while (currentLine != null)
            {    
                //splitting the currentLine into words
                 
                String[] words = currentLine.toLowerCase().split(" ");
                 
                //Iterating each word
                 
                for (String word : words)
                {
                    //if word is already present in wordCountMap, updating its count
                     
                    if(map.containsKey(word))
                    {    
                        map.put(word, wordCountMap.get(word)+1);
                    }
                     
                    //otherwise inserting the word as key and 1 as its value
                    else
                    {
                        map.put(word, 1);
                    }
                }
                 //Reading next line into currentLine
                 
                currentLine = reader.readLine();
     }
     // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<HashMap.Entry<String, Integer>>(map.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override 
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }//decending order
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
     /*   Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/
        for(int i=0; i < k; i++) {
       System.out.println(list.get(i).getKey());
    }//list is sort by map.value deceding value print first k = print top k frequent 

}
}

