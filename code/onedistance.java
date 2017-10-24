public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (Math.abs(len1-len2)>1||s.equals(t)) return false;
        int i=0,j=0,count =0;
        while (i<len1&j<len2)
        {
            if (s.charAt(i)!=t.charAt(j))
            {
                 count ++;
                 if(count>1) return false;
                if (len1==len2) {i++;j++;}
                else if (len1>len2) {i++;}
                else {j++;}
            }
            else {
            i++;j++;
            }
        }
        return count==1||Math.abs(len1-len2)==1;
        }
}
/*
 public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
         if (Math.abs(len1-len2)>1||s.equals(t)) return false;
         else if (len1==0||len2==0) return true;
         int len = Math.min(len1,len2);
        for (int i = 0; i<len;i++)
        {
            if(s.charAt(i)!=t.charAt(i))
             if (len1==len2)
             return s.substring(i+1).equals(t.substring(i+1));
             else if (len1>len2)
              return s.substring(i+1).equals(t.substring(i));
              else
              return s.substring(i).equals(t.substring(i+1));
        }
        return Math.abs(len1-len2)==1;
        }
        */