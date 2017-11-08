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
      int x =12345;
      int result = reverse(x);
     System.out.print(result);
  }
       public static int reverse(int x) {
         int result =0;
         while (x!=0)
         {
           int tail = x%10;
           int result2 = result*10+tail;
           if ((result2-tail)/10 !=result)return 0;
           result = result2;
           x/=10;
         }
         return result;
    }
}
