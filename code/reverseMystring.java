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
   /* ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }*/
    String input = "zhengkai, zhang kirk zhang";
    String output = reverse(input);
    System.out.print(output);
  }
  public static String reverse(String s)
  {
     String [] parts = s.trim().split("\\s+");
    String result = reverseString(parts[0])+" ";
    for (int i =1;i<parts.length-1;i++)
    {
      result += reverseString(parts[i]) +" ";
    }
    return result +reverseString(parts[parts.length-1]);
  }
  public static String reverseString(String s)
  {
       char [] result = s.toCharArray();
      int i =0,j=s.length()-1;
      while (i<j)
      {
        while (result[j]==',') j--;
        while (result[i]==',') i++;
        char temp = result [i];
        result [i] = result[j];
        result [j] = temp;
        i++;
        j--;
      }
    return new String(result);
  }
}

