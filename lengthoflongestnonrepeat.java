import java.io.*;
import java.util.*;



public class test {
  public static void main(String[] args) {
       String input = "abcabcbb";
       int result = LengthoflongestNorepeatString(input);
      System.out.println(result);
  }
  public static int LengthoflongestNorepeatString (String s)
  {
    HashMap<Character,Integer> map = new HashMap<>();
    int max =0;
    for (int end=0,start=0;end<s.length();end++)
    {
        if (map.containsKey(s.charAt(end)))
        start = Math.max(start,map.get(s.charAt(end))+1);
        //first non repeat position for start
        map.put(s.charAt(end),end);//save position for the end char
        max = Math.max(max,end-start+1);
        //update the longest length with current window of none repeat substring
    }
    return max;
  }
 
}
