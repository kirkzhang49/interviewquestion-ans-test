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
    int x = 223336226;
    int result = DuplicateNumber(x);
    System.out.print(result);
  }
  public static int DuplicateNumber (int X){
    int max=Integer.MIN_VALUE;
    String IntString = String.valueOf(X);
    for (int i = 1; i<IntString.length();i++)
    {
      if (IntString.charAt(i-1)==IntString.charAt(i))
      {
        String subS = IntString.substring(0,i) + IntString.substring(i+1);//delete i
        //StringBuilder b = new StringBuilder(builder.toString());
        //b.deleteCharAt(i);
        int a = Integer.valueOf(subS);
        if (a>max)
        {
          max = a;
        }
      }
    }
    return max;
  }
  public static int avg (int X)
  {
    int max = Integer.MIN_VALUE;
     String IntString = String.valueOf(X);
    for (int i =1;i <IntString.length();i++)
    {
      char c1 = IntString.charAt(i-1);
      char c2 = IntString.charAt(i);
      int num1 = Character.getNumericValue(c1);
      int num2 = Character.getNumericValue(c2);
      int roundup = (num1+num2+1)/2;
      String ansString = IntString.substring(0,i-1)+String.valueOf(roundup)+IntString.substring(i+1);
      //delete i-1 and i  insert the avg
      int a = Integer.valueOf(ansString);
      if (a>max)
      {
        max =a ;
      }
    }
    return max;
  }
  
    public static int adjL (int X)
  {
    int min = Integer.MAX_VALUE;
     String IntString = String.valueOf(X);
    for (int i =1;i <IntString.length();i++)
    {
      char c1 = IntString.charAt(i-1);
      char c2 = IntString.charAt(i);
      int num1 = Character.getNumericValue(c1);
      int num2 = Character.getNumericValue(c2);
      int compare = num1>num2 ?num1:num2;
      String ansString = IntString.substring(0,i-1)+String.valueOf(compare)+IntString.substring(i+1);
      //delete i-1 and i  insert the avg
      int a = Integer.valueOf(ansString);
      if (a<min)
      {
        min =a ;
      }
    }
    return min;
  }
  
}

