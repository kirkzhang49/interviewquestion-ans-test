class Solution {
    public boolean isAnagram(String s, String t) {
            int [] check = new int [26];
        for (int i=0;i<s.length();i++) check[s.charAt(i)-'a']++;
        for (int j=0;j<t.length();j++) check[t.charAt(j)-'a']--;
        for (int i:check) if(i!=0) return false;
        return true;
    }
}