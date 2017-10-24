public class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i=s.length()-1;i>=0;i--)
        {
            if (s.charAt(i)==s.charAt(j))
            {
                j+=1;//if left and right equal increase position of left
            }
        }
        if (j==s.length()) return s;//if left equal to right entirly!
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() +shortestPalindrome(s.substring(0,j)) +suffix;
        //every thing after j can't help to save space so just reverse it to make palindrome
    }
}