public class Solution {
    public int numDecodings(String s) {
        if (s==null||s.length()==0)
        {
            return 0;
        }
        int  n = s.length();
        int [] dp = new int [n+1];
        dp [0] =1;//empty is 1
        dp[1] = s.charAt(0)!= '0' ?1:0;
        //if charAt(0) not equal to 0 it is 1 else 0
        for (int i=2;i<=n;i++)
        {
          int first = Integr.valueOf(s.substring(i-1,i));
          int second = Integr.valueOf(s.substring(i-2,i));
          if (first>=1&&first<=9)//if first part string is between 0 and 9
          {
            dp[i] += dp[i-1];//add one from pervious ways 
          }
          if (second>=10&&second<=26)
          {  // add one from pervious two
              dp[i] += dp[i-2];//two decode ways
          }
        }
        return dp[n];//until last
    }
}

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/