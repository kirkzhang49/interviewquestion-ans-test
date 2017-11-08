class Solution {
    public boolean search(int[] nums, int target) {
         if(nums==null||nums.length==0) return false;
         int left =0, right = nums.length-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if (nums[mid]==target) return true;
            if (nums[mid]==nums[left]) left++;
           else if (nums[mid]>nums[left]){
                if (target>=nums[left]&&target<nums[mid]) right=mid-1;
                else left = mid+1;
            }
            else {
                if (target>nums[mid]&&target<=nums[right]) left = mid+1;
                else right = mid-1;
            }
            
        }
        return false;
    }
}

public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {//first decrease as min 
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }
}