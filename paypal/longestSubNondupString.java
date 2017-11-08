import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
   List<String> input =  new ArrayList<>(); 
  input.addAll(Arrays.asList("kirk","cats", "turtles","kirk", "cats", "rats", "dogs", "rabitts"));
     input.add("kirk");
    input.add("zhang");
   List<String> result =  NondupSubArray(input);
    for (String s:result){
      System.out.println(s);
    }
  }
  
  
   public static List<String> NondupSubArray(List<String> input){
          HashMap <String,Integer> map = new HashMap<>();
        int startIndex=0,endIndex=0,maxLen = Integer.MIN_VALUE;
     for (int start=0,end=0;end<input.size();end++){
            String key = input.get(end);
          if(map.containsKey(key)){
              start=Math.max(start,map.get(key)+1);
          }
        map.put(key,end);
             if (maxLen<end-start+1)
             {
               maxLen = end-start+1;
               startIndex = start;
               endIndex = end;
             }
     }
          List<String> result = new ArrayList<>();
      for (int i=startIndex;i<=endIndex;i++){
            result.add(input.get(i));   
      }
             return result;
        
    } 
    }