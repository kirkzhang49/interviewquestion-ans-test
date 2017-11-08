
class Solution {
  public static void main(String[] args) {
      int [] nums = {5,3,1,7,2,-10,321,555,22,33,4,1,-1,-100,22,55};
      int [] result = max_min(nums);
     System.out.print(result[0]+"--"+result[1]);
  }
       public static int[] max_min(int [] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
         int maxIndex =0,minIndex=0;
        for (int i=0;i<nums.length;i++)
        {
          if (nums[i]>max){
            max = nums[i];
            maxIndex=i;
          }
          if (nums[i]<min){
            min = nums[i];
            minIndex=i;
          }
        }
         int [] result = new int [2];
         result[0] = maxIndex; 
         result[1] = minIndex;
         return result;
    }
}