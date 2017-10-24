// for 1<=a[i]<=n (n is the size of array)
//positive
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i =0;i<nums.length;i++)
        {
            int index = Math.abs(nums[i]);//find the match index
            if (nums[index-1]>0)//if the number of match index positive
            {
                nums[index-1] = -nums[index-1];//make it negative since will use absolute to check so it won't effect us
            }
            else//if the index in nums already make to negative it duplicated
            {
                result.add(Math.abs(nums[i]));
            }
        }
        return result;
    }
}

// for 1<=a[i]<=n (n is the size of array)
//positive
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
              List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++ )
        {
            if(map.containsKey(nums[i])){
                result.add(nums[i]);
            }
            map.put(nums[i],i);
        }

        return result;
    }
}