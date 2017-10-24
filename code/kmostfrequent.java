// use an array to save numbers into different bucket whose index is the frequency
public class Solution {
    private class Node implements Comparable<Node> {
        private int val;
        private int freq;

        public Node(int val, int freq) {//create node 
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Node that) {//help for heap comparable
            return this.freq - that.freq;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {//save all frequent to the map
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
            if (pq.size() > k) pq.poll();//if size larger than k throw the min out 
        }//remian will be the k most frequent
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll().val);//add all k to result
        return result;
    } 
}

//use an array to save numbers to slove question

public class Solution{
    public List<Integer> topK(int [] nums, int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List <Integer> [] bucket = new List [nums.length+1];
        for (int n :map.KeySet())
        {
            int freq = map.get(n);
            int (bucket[freq] == null)
               bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }
        List <Integer> result = new LinkedList<>();
        for (int i =bucket.length-1;i>0&&k>0;--i)
        {
            if (bucket[i]!null)
            {
                List<Integer> list =bucket[i];
                result.addAll(list);
                k-= list.size();
            }
        }
        return result;
    }

}