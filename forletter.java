 public static int forLetter (String s){
    int count =0, temp =0;
    for (int i=0;i<s.length();i++)
    {
      if (s.charAt(i)!=' ')
        temp++;
      else 
      {
         if (temp==4)
         {
            count++;
           temp=0;
         }
        temp=0;
      }
  }
    if (temp==4) count++;
    return count;
}