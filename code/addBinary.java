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
    String a = "101", b ="11";
    String result = addBinary(a,b);
    System.out.print(result);
  }
   public static String addBinary(String a, String b) {
     int lena = a.length();
     int lenb = b.length();
     int i=0,carry=0;
     String res = "";
     while (i <lena || i<lenb||carry!=0)//one of condition true loop continue
     {
       int x = (i<lena) ? Character.getNumericValue(a.charAt(lena-1-i)):0;
       //get from most right
       int y = (i<lenb) ? Character.getNumericValue(b.charAt(lenb-1-i)):0;
        res = (x+y+carry)%2 +res;//String plus
       carry = (x+y+carry)/2;
         i++;
     }
     return res;
    }
}

