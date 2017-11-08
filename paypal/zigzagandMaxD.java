public class Solution {
    public String convert(String s, int numRows) {
            char [] c =s.toCharArray();
          int len = c.length;
           StringBuilder [] sb = new StringBuilder[numRows];
        for (int i=0;i<sb.length;i++) sb[i] = new StringBuilder();
        int i =0;
        while (i<len)
        {
            for (int index=0;index<numRows&&i<len;index++)
                sb[index].append(c[i++]);//vertical down
            for (int index=numRows-2;index>=1&&i<len;index--)
                sb[index].append(c[i++]);//up
        }
        for (int index =1;index<sb.length;index++)
            sb[0].append(sb[index]);
        return sb[0].toString();
    }
}

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        
        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        
        return result;
    }
}