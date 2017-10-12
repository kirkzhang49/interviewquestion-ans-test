import java.io.*;
import java.util.*;



public class test {
  public static void main(String[] args) {
        int [] input = {1,2,2,3,3,1,4,5,5};
      int result = singleNum(input);
      System.out.println(result);
  }
  public static int singleNum (int[] nums)
  {
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int i=0;i<nums.length;i++)
    {
        if (map.containsKey(nums[i]))
         map.put(nums[i],map.get(nums[i])+1);
         else map.put(nums[i],1);
    }
    for (Map.Entry<Integer,Integer> m:map.entrySet())
    {
        if (m.getValue()==1)
        return m.getKey();
    }
    return 0;
  }
 
}
