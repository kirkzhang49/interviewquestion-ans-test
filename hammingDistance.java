import java.io.*;
import java.util.*;

//java modifier


public class test {
  public static void main(String[] args) {
     /*  String input = "abcabcbb";
       int result = LengthoflongestNorepeatString(input);
      System.out.println(result);*/
    int result = hammingDistance(1,4);
    System.out.println(result);
  }
  
 public static int hammingDistance(int x, int y) {
        int xor = x^y,count =0;
        for (int i=0;i<32;i++) count+= (xor>>i)&1;
        return count;
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
