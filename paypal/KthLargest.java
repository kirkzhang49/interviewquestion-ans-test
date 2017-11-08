public int findKthLargest(int[] nums, int k) {

    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}


public int findKthLargest(int[] nums, int k) {//just sort
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}


//difficult way 
public class Solution {
    public int findKthLargest(int[] nums, int k) {
      if (nums==null||nums.length==0) return 0;
        Queue<Integer> maxheap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare (Integer i1,Integer i2)//modify heap to maxheap initial is min heap
            {
                if (i1<i2) return 1;//for max heap
                else if (i1>i2) return -1;
                else return 0;
            }
        });
        for (int i=0;i<nums.length;i++)
        {
            maxheap.offer(nums[i]);//add all to max heap top will out first
        }
        int count =0,value=0; 
        while (count<k&&!maxheap.isEmpty())//until count ==k it is kth
        {
            value = maxheap.poll();
            count++;
        }
        return value;
    }
}

 