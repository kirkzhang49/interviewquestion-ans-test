public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null||nums.length==0)
          return 0;
          Queue<Integer> maxheap = new PriorityQueue<Integer>(new Comparator<Integer>(){
             public int compare (Integer i1, Integer i2)
             {
                 if (i1<i2)//change less to return one,so make it maxheap
                 {
                     return 1;
                 }
                 else if (i1>i2)
                 {
                     return -1;
                 }
                 else 
                 {
                     return 0;
                 }
             }
          });
          for (int i =0; i <nums.length; i ++)
          {
              maxheap.offer(nums[i]);//add to PriorityQueue
          }
        int count=1; int val=maxheap.poll();
        while (count<k&&!maxheap.isEmpty())
        {
            val = maxheap.poll();//use heap to get largest
            count++;//until kth largest
        }
        return val;
    }
}