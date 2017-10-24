public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s,result,0,0,new char []{'(',')'});
    }
    public void remove(String s,List<String> result,int lasti,int lastj,char [] par)
    {
        for (int stack =0;i=lasti;i<s.length();++i)
        {
            if (s.charAt(i)==par[0]) stack++;
            if (s.charAt(i)==par[1]) stack--;
            if (stack>=0) continue;//if stack >=0 means more or zero (
                //if negative go to loop because it has problem
            for (int j = lastj;j<=i;++j)
            {
                if ((s.charAt(j)==par[1])&&(j==lastj||s.charAt(j-1)!=par[1]))
                //remove j inorder to elimate one negative 
                {
                 remove(s.substring(0,j)+s.substring(j+1,s.length()),result,i,j,par);
                }
            }
            return ;
        }//reverse for all possible
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')//finished left to right
        {
            remove(reversed,result,0,0, new char[] {')','('});
        }
        else//finished right to left 
          result.add(reversed);
    }
}