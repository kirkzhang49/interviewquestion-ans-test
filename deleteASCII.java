import java.io.*;
import java.util.*;



public class test {
  public static void main(String[] args) {
  /*  ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }*/
    String str1 = "thought";
    String str2 = "sloughs";
    int n = delete(str1,str2);
    System.out.print(n);
  }
  public static int delete (String s1,String s2)
  {
     int [] checker = new int [256];
    int result =0,times=0;
    for (int i=0;i<s1.length();i++) checker[(int)s1.charAt(i)]++;
    for (int i=0;i<s2.length();i++) checker[(int)s2.charAt(i)]--;
    for (int i=0;i<256;i++)
    {
       if(checker[i]!=0)
       {
         times = Math.abs(checker[i]);
         result +=(times*i);
       }
    }
    return result;
  }
 
}
