class Solution {
  public static void main(String[] args) {
    int [] nums = {3,5,2,7,9,1,8};
    List<List<Integer>> result = new ArrayList<>();
    result = twosum(nums,9);
    for (int i=0;i<result.size();i++)
    {
      System.out.print(result.get(i).get(0)+","+result.get(i).get(1));
      System.out.println("");
    }

  }
  public static List<List<Integer>> twosum(int [] nums, int target)
{
   HashSet<Integer> set = new HashSet<>();
   List<List<Integer>> result = new ArrayList<>();
  for (int i=0;i<nums.length;i++)
  {
    if (set.contains(target-nums[i]))
    {
       result.add(Arrays.asList(nums[i],target-nums[i]));
    }
    else set.add(nums[i]);
  }
  return result;
  
   
}
}