import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
      MyStack theStack = new MyStack(6); 
      theStack.push(10);
      theStack.push(20);
      theStack.push(30);
      theStack.push(40);
      theStack.push(50);
        theStack.push(40);
      theStack.push(50);
      
      while (!theStack.isEmpty()) {
         int value = theStack.pop();
         System.out.print(value);
         System.out.print(" ");
      }
      System.out.println("");

  }
  public static class MyStack{
    private int maxsize = 1000;
    private int [] stackArray;
    private int top;
    public MyStack (int n){
      maxsize = n;
      stackArray = new int[maxsize];
      top = -1;
    }
    public void push (int v){;
        top++;
        if (top>maxsize*0.8)
        {
          System.out.println("size changed!");
          int [] temp = Arrays.copyOf(stackArray,maxsize);
          int tSize = maxsize;
          maxsize *=2;
          stackArray = new int[maxsize];
          for (int i=0;i<top;i++){
            stackArray[i] = temp[i];
          }
        }
      stackArray[top] =v;
    }
    public int pop(){
      return stackArray[top--];
    }
        public int peek(){
      return stackArray[top];
    }
    public boolean isEmpty(){
      return top==-1;
    }
  }
}
