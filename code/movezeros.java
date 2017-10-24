public class Solution {
    public void moveZeroes(int[] nums) {
        int y = 0,temp=0,len=nums.length;
        for (int x=0;x<len;x++)
        {
            if(nums[x]!=0)//swap all non zeros to first position
            {
                temp = nums[y];
                nums[y] = nums[x];
                nums[x] = temp;
                y++;
            }//if it is zero move on and don't change y
            //all non zeros will in y position and zeros will be x position
            //as temp may be zeros 
        }
    }
}