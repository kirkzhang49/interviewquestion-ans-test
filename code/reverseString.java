public class Solution {
    public String reverseString(String s) {
        char []result = s.toCharArray();
        int i = 0,j = result.length-1;
        while (i<j)//two point both way revese string
        {
            char temp = result[i];
            result[i]= result [j];
            result[j]=temp;
            i++;
            j--;
        }
        return new String(result);
    }
}