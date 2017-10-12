import java.io.*;
import java.util.*;

//java modifier


public class test {
  public static void main(String[] args) {
    
    String result = longestPalindrome("babad");
    System.out.println(result);
  }
  
   public static String longestPalindrome(String s) {
        String result = "";
        int len=0;
        for (int i=0;i<s.length();i++)//sliding window for extend length
        {
            if (checkPalindrome(s,i-len-1,i))//even length -1 +1 
            {
                result = s.substring(i-len-1,i+1);//i+1 is until i
                len+=2; //extend 1
            }
            else if (checkPalindrome(s,i-len,i))
            {
                result = s.substring(i-len,i+1);
                len+=1;
            }
        }
        return result;
    }
    public static Boolean checkPalindrome(String s, int left,int right)
    {
        if (left<0) return false;
        while (left<right)
        {
            if (s.charAt(left++)!=s.charAt(right--))
            return false;
        }
        return true;
    }

}


