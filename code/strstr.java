public class Solution {
    public int strStr(String haystack,String needle)
    {
        //if (haystack.length<needle.length)return -1;
        //return haystack.indexof(needle);
        for (int i=0;i<haystack.length()-needle.length+1;i++)//max to i equal to total length-sublength
        {
           if (haystack.substring(i,i+needle.length()).equals(needle))
           {
               return i;//if start from i +the length of needle equal to needle.
           }
        }
    }
}

public class Solution {//Solution 1: O(m+n) KMP pattern matching
   public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        
        int[] parr = kmpPreprocess(needle);
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            } else if(j > 0) {
                j = parr[j - 1];//if not match and j >0 go backward
            } else {
                i++;//not match and not j>0 i increase
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private int[] kmpPreprocess(String pattern) {
        int i = 1, j = 0;
        int[] res = new int[pattern.length()];
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {//if i = j res [i] = j+1 since repeat
                res[i] = j+1;
                i++; j++;
            } else if (j > 0) {//if not j = res[j-1]
                j = res[j-1];
            } else {//else res[i]=0 i increase
                res[i] = 0;
                i++;
            }
        }
        return res;
    }
}

public class Solution {
   public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int len = haystack.length(), i = 0, j = 0, pos = 0;
        while(i < len && j < needle.length()) {
            if(haystack.charAt(i++) == needle.charAt(j)) {//if i and j in both equal both increase
                j++;
            } else {//if not equal
                i = i - j;//i go back for j position
                j = 0;//j reset to zero
                pos = i;//record i
            }
            if (j==needle.length()) break; // if get all mathch break
        }
        return j == needle.length()? pos : -1;//if j equal to needle.length return position else return -1
    }
}