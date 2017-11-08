class Solution {
  public static void main(String[] args) {
    int [] nums = {1,5,-6,8,2,3,-5,22,-17,3,-3,31};
    int [] result = subarraySum(nums);
    System.out.print(result[0]+" : "+result[1]);

  }

    public static int[] subarraySum(int[] nums) {
            int start =0,end=0,Cur_sum=0,max=0;
      for (int i=0;i<nums.length;i++){
          Cur_sum =0;
        for (int j=i;j<nums.length;j++){
            Cur_sum+= nums[j];
           if (Cur_sum ==0){
              if (max<j-i+1){
                max = j-i+1;
                start=i;
                end =j;
              }
           }
        }
      }
      int [] result = {start,end}; 
      return result;
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
            int sum =0,result =0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//one way to add to zero
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            result += map.getOrDefault(sum-k,0);//result add number of ways previously add to sum-k  which add make all possible add to k
            map.put(sum,map.getOrDefault(sum,0)+1);//number of ways add to sum
        }
        return result;
    }
}


// Returns length of the largest subarray
// with 0 sum
static int maxLen(int arr[], int n)
{
    int max_len = 0; 
 
    // Pick a starting point
    for (int i = 0; i < n; i++)
    {
        // Initialize curr_sum for every
        // starting point
        int curr_sum = 0;
 
        // try all subarrays starting with 'i'
        for (int j = i; j < n; j++)
        {
            curr_sum += arr[j];
 
            // If curr_sum becomes 0, then update
            // max_len
            if (curr_sum == 0)
                max_len = Math.max(max_len, j-i+1);
        }
    }
    return max_len;
}
