
class Solution {
  public static void main(String[] args) {
    String word1 = "kirk";
    String word2 = "zhang kirk 49";
     System.out.println(strstr(word1,word2));
  }

    public static int strstr(String word1,String word2)
    {
      for (int i=0;;i++)
      {
        for (int j=0;;j++)
        {
          if (j==word1.length()) return i;
          if (i+j==word2.length()) return -1;
          if (word1.charAt(j)!=word2.charAt(i+j))break;
        }
      }
    }
}