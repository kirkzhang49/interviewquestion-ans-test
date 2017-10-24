public class Solution {
    private static final String [] KEYS =  { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits)
    {
         
        List<String> ret = new LinkedList<String>();
         if (digits ==null||digits.length()==0)
          return ret;
        combination("",digits,0,ret);
        return ret;
    }
 private void combination(String prefix,String digits,int offset, List<String> ret)
 {
     if (offset>=digits.length())//if offset >= to the entire length add to the result
     {
         ret.add(prefix);
         return;
     }
     String letters = KEYS[(digits.charAt(offset)-'0')];//the represent letter by input
     for (int i =0;i<letters.length();i++)//all possible letters in KEYS
     {
         combination(prefix+letters.charAt(i),digits,offset+1,ret);
         //try all possible letter[i] and offset +1 
     }
 }
}

/* FIFO QUEUE
 public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length();i++){
        int x = Character.getNumericValue(digits.charAt(i));
        while(ans.peek().length()==i){
            String t = ans.remove();
            for(char s : mapping[x].toCharArray())
                ans.add(t+s);
        }
    }
    return ans;
}
*/