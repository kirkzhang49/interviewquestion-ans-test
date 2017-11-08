class Solution {
    public String reverseString(String s) {
         int left =0 , right=s.length()-1;
         char [] str = s.toCharArray();
        while (left<=right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;right--;
        }
        return new String(str);
    }
}