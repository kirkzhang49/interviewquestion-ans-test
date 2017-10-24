public class Solution {
    public boolean isMatch(String s, String p) {
    if (p.isEmpty())
    {
        return s.isEmpty();
    }
    if (p.length()==1||p.charAt(1)!='*')//p has only one char or p(1) = *
    {
     if (s.isEmpty()||(p.charAt(0)!='.'&&p.charAt(0)!=s.charAt(0)))
     {//in this condition if s is empty or p(0) is not . and first is not equal
         return false;//it is false 
     }
     else 
     {
       return isMatch(s.substring(1),p.substring(1));
       //else it is match so continue it
     }
    }//p's length larger than equal to 2
    while(!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'))
    {// if while condition true we can move one more
        if(isMatch(s,p.substring(2)))
        {// if it is true whole true
            return true;
        }
        s=s.substring(1);//recusive move one more
    }
    return isMatch(s,p.substring(2));
    }
}
public class Solution {
    public boolean isMatch(String s , String p)
    {
     int m = s.length();
     int n = p.length();
     if (s==null||p==null)
     return false;
     boolean [][] OPT =new boolean[m+1][n+1];
     OPT[0][0] =true;
     for (int i=1;i<=m;i++)//for all OPT[i][0] is false
     {
         OPT[i][0] =false;
     }
     for (int j =1;j<=n;j++)
    {
     OPT[0][j] = (p.charAt(j-1)=='*')&&(j-2>=0)&&OPT[0][j-2];
     //if j -1 = * and [0][j-2] is true than OPT[0][j] is true  
    }
    for (int i=1;i<=m;i++)
    {
    for (int j=1;j<=n;j++)
    {
OPT[i][j]=((OPT[i-1][j-1])&&euqals(s,p,i-1,j-1))//if previous is equal and OPT is true true
||((OPT[i-1][j])||OPT[i][j-1])&&(p.charAt(j-1)=='*')&&equals(s,p,i-1,j-2)
//if j-1 is * which means repeat check if i-1 and j-2 is equal and one of i-1 or j-1 is euqal
||((p.charAt(j-1)=='*')&&(j-2>=0)&&OPT[i][j-2]);
//j-1 is * and OPT [i][j-2] is true than true 
    }
    } 
    return OPT[m][n];
      }
      private boolean equals(String s,String p, int si,int pi)
      {
          return (s.charAt(si)==p.charAt(pi))||p.charAt(pi)=='.';
      }
     }
 