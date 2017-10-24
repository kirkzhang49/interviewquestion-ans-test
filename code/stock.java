public class Solution {
    public int maxProfit(int[] prices) {
       int len = prices.length-1;
       int max =0;
       for (int i =0;i<len;i++)
       {
           if (prices[i+1]>prices[i]) max += (prices[i+1]-prices[i]);
       }
       return max;
    }
}