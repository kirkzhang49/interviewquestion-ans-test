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
    String [] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> result = new ArrayList<>();
    result = groupAnagrams(input);
    for (int i=0;i<result.size();i++)
    {
      List<String> nest = result.get(i);
      for (String s:nest)
      {
        System.out.print(s+" ");
      }
      System.out.println(".");
    }
  }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0||strs==null) return new ArrayList<List<String>>();
        HashMap <String,List<String>> map = new HashMap<>();
        Arrays.sort(strs);
        for (String s:strs)
        {
          char [] ca = s.toCharArray();
          Arrays.sort(ca);
          String KeyVal = String.valueOf(ca);
          if(!map.containsKey(KeyVal)) map.put(KeyVal,new ArrayList<String>());
          map.get(KeyVal).add(s);
        }
      return new ArrayList<List<String>>(map.values());
    }
}

