import java.io.*;
import java.util.*;



public class test {
  public static void main(String[] args) {
    String str = "zhang";
    String result = reverse(str);
    System.out.print(result);
  }
  public static String reverse (String s)
  {
     char [] word = s.toCharArray();
     int left = 0, right = s.length()-1;
     while (left<right)
     {
         char temp = word[left];
         word[left]=word[right];
         word[right]=temp;
         left++;
         right--;
     }
     return new String(word);
  }
 
}
