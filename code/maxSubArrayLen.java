import java.io.*;
import java.util.*;

/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
 */

class Solution {
  public static void main(String[] args) {
     int [] nums = new int []{1,-1,5,-2,3};
    int a= maxSubArrayLen(nums,3);
    System.out.print(a);
  }
 public static int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++)//add up
            nums[i] += nums[i - 1];
            //map value as key position as get
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // add this fake entry to make sum from 0 to j consistent
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k))
                max = Math.max(max, i - map.get(nums[i] - k));//if nums[i] - k exist in map, use i - get index as maxlength
            if (!map.containsKey(nums[i])) // keep only 1st duplicate as we want first index as left as possible
                map.put(nums[i], i);//left most exist number and if find nums[i] - k equal to map number exist
                //check with current max to get max
        }
        return max;
    }
}

