public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) { //if i is duplicate wont go to inside
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];//calculate the sum
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {//if sum is zero add to list
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));//add to list
                    while (lo < hi && num[lo] == num[lo+1]) lo++;//skip duplicate from low
                    while (lo < hi && num[hi] == num[hi-1]) hi--;//skip duplicate from high 
                    lo++; hi--;//update low and high
                } else if (num[lo] + num[hi] < sum) lo++;//if less increase low
                else hi--;//if great decrease high
           }
        }
    }
    return res;
}
}