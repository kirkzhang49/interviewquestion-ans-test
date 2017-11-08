public class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0 ) return "Zero";
        int i = 0;
        String words = "";
        while (num>0)
        {
            if (num%1000!=0)
               words = helper(num%1000) +THOUSANDS[i] +" "+words;
               num/=1000;//decrease by 1000 divide
               i++;
        }//each 1000 we need to increase thousands level + " " + words
        return words.trim();        
    }
    private String helper(int num)
    {
          if (num == 0)
          return "";
          else if (num<20)//for less than 20
          return LESS_THAN_20[num] + " ";
          else if (num<100)//for less than 100 use TENS[num/10] + remain use helper
            return TENS[num/10]+" "+helper(num%10);
        else//else larger than 100 so add Hundred + helper(remain)
          return LESS_THAN_20[num/100] + " Hundred " + helper(num%100);

    }
}