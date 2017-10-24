class Solution {
  public static void main(String[] args) {
    String input = "Let's take LeetCode contest";
    String result = reverseWords(input);
     System.out.println(result);
  }

    public static String reverseWords(String s) {
        char [] result = s.toCharArray();
        int i=0;
         for (int j=0;j<s.length();j++)
         {
           if (result[j]==' ')
           {
             reverse(result,i,j-1);//before space
             i=j+1;//record location
           }
         }
        reverse(result,i,s.length()-1);
      return new String(result);
    }
    public static void reverse(char [] str,int left,int right){
          while(left<right)
          {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
          }
    }
}