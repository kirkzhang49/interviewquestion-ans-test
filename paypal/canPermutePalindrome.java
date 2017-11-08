class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> result = new HashSet<>();
        for (int i=0;i<s.length();i++){
            if (!result.contains(s.charAt(i))) result.add(s.charAt(i));
            else result.remove(s.charAt(i));
        }
        return result.size()<=1;
    }
}