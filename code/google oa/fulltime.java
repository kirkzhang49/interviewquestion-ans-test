class Solution
{
    public int removeSolution(int x)
    {
//from left to right find first valid number to remove, whose next element
//is larger than itself In this case 3 is larger than 2
      int result = -1;
      if (x >=11&&x<=111111111)
      {
         String s = String.valueOf(x);
         //translate int value to string
         int lastRepeatPos = -1;
     for (int i =1 ; i<s.length();i++)
     {
      if (s.charAt(i-1) == s.charAt(i))
      {
       lastRepeatPos = i ;
       if (i == s.length()-1 ||s.charAt(i+1)>s.charAt(i))
       {//next char is larger than current or repeat one is last one elimiate i 
result = Integer.parseInt(s.substring(0,i)+s.substring(i+1,s.length()));
 lastRepeatPos =-1;// won't cut again
 break;
       }
      }  
     }
     if (lastRepeatPos !=-1)
     {
    result = Integer.parseInt(s.substring(0,lastRepeatPos)+s.substring(lastRepeatPos+1,s.length()));
     }
      }
      return result
    }
}

public int Solution1(int X)
{//remove one duplicate return the largest integer
    if (X<11||X>1000000000)return -1;
    String s = String.ValueOf(X);
    int max = 0;
    char lastChar = s.charAt(0);
 for (int i =1;i<s.lengthg();i++)
 {
     char curChar = s.charAt(i);
     if (lastChar ! = curChar)
     {
         lastChar = curChar;
     }//if repeat not need to modify lastChar
     else 
     {
         String sub = s.substring(0,i)+s.substring(i+1);
         max = Math.max(max,Integer.parseInt(sub));
     }
 }
 return max;
}

