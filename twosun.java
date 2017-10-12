import java.util.*;

public class test{

     public static void main(String []args){

        int [] input =new int []{1,2,3,4,5,6,7};
       int []result= twoSum(input,5);
      System.out.println(result[0]);
        System.out.println(result[1]);

     }
       
    public static int[] twoSum(int[] nums,int target)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
            if (map.containsKey(target-nums[i]))
            return new int []{i,map.get(target-nums[i])};
            else map.put(nums[i],i);
        }
        return null;
    }
    
}