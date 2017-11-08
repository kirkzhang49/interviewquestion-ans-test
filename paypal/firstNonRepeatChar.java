class Solution {
    public int firstUniqChar(String s) {
            int [] check = new int [26];
        for (int i=0;i<s.length();i++){
            check[s.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++){
            if(check[s.charAt(i)-'a']==1)return i;
        }
        return -1;
    }
}