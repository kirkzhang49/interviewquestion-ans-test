import java.io.*;
import java.util.*;



public class test {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    int result;
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    result = minStack.getMin();   // Returns -3.
    System.out.println(result);
    minStack.pop();
    result = minStack.top();      //Returns 0.
     System.out.println(result);
    result = minStack.getMin();   // Returns -2.
     System.out.println(result);
  }
  public static class MinStack
  {
      int min;
      Stack<Integer> stack;
    public MinStack()
    {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    public void push(int x)
    {
        if (x<=min)
        {
            stack.push(min);//record for last min for update new min
            min = x;
        }
        stack.push(x);//stack will always push x
    }
    public int pop()
    {
        int result = stack.peek();
        if (stack.pop()==min) min = stack.pop();//update min with last record min since pop the current min
        return result;
    }
    public int top()
    {
        return stack.peek();
    }
    
    public int getMin()
    {
        return min;
    }
  }

}


