//find the longest repeat string with k replacement
public class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int [] count = new int [26];
        int start = 0,maxcount=0,maxlength=0;
        for (int end =0;end <len;end ++)
        {
            maxcount = Math.max(maxcount,++count[s.charAt(end)-'A']);
            //find the most repeat letter in string
            while (end - start +1 -maxcount >k)//total k replacement window
            // - most repeat one need be equal to  k
            {
              count[s.charAt(start)-'A']--;//move start then decrease the count number
              start++;//adjust window move start and delete start for window move
            }
            maxlength = Math.max(maxlength,end-start+1); //largest window = largest length
        }//find the max length
        return maxlength;
    }
}