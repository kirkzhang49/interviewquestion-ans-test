  public static int bracket (String s)
  {
    Stack<Character> stack = new Stack<>();
    int count =0,extra=0;
    for (int i=0;i<s.length();i++)
    {
      if (s.charAt(i)=='(') stack.push('(');
      if (s.charAt(i)==')')
      {
        if (!stack.isEmpty()&&stack.peek()!='(')
        {
          count++;
        }
        else if (stack.isEmpty()) 
          extra++;
        else 
        stack.pop();
      }
    }
    return count+extra+stack.size();
  }

  