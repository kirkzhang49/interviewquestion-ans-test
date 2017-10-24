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
   /* ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }*/
    String x = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
    int result = DirMAXImage(x);
    System.out.print(result);
  }
    public static int DirImage (String S){
    int result =0,curLen=0;
    if (S == null ||S.length()==0) return 0;
    String [] lines = S.split("\n");//split by \n
    Stack<String> stack = new Stack <String>();
    stack.push("");//root
    HashSet<String> pathCheck = new HashSet<String>();
    //which folder contains file,so won't contain duplicate path
    for (int i =0;i<lines.length;i++)
    {
      int level = 0;
      while (level <lines[i].length()&&lines[i].charAt(level)==' ')
      {
         level++;
      }
      boolean fileCheck = check1(lines[i]);
      while (!stack.peek().equals("")&&level+1<stack.size())
      {
        String currentLevel = stack.pop();
        curLen -=(currentLevel.length()+1);
      }//get to the level just above current level
      if (!fileCheck)
      {
        stack.add(lines[i].trim());
        curLen +=(lines[i].trim().length()+1);
      }
      else if (!pathCheck.contains(stack.peek()))
      {
        result += curLen +lines[i].trim().length()+1;
        //include the image length
        pathCheck.add(stack.peek());
      }
    }
    return result;
  }
  public static int DirMAXImage (String S){
    int max =0,curLen=0;
    if (S == null ||S.length()==0) return 0;
    String [] lines = S.split("\n");//split by \n
    Stack<String> stack = new Stack <String>();
    stack.push("");//root
    HashSet<String> pathCheck = new HashSet<String>();
    //which folder contains file,so won't contain duplicate path
    for (int i =0;i<lines.length;i++)
    {
      int level = 0;
      while (level <lines[i].length()&&lines[i].charAt(level)==' ')
      {
         level++;
      }
      boolean fileCheck = check1(lines[i]);
      while (!stack.peek().equals("")&&level+1<stack.size())
      {
        String currentLevel = stack.pop();
        curLen -=(currentLevel.length()+1);
      }//get to the level just above current level
      if (!fileCheck)
      {
        stack.add(lines[i].trim());
        curLen +=(lines[i].trim().length()+1);
      }
      else if (!pathCheck.contains(stack.peek()))
      {
        int temp = curLen +lines[i].trim().length()+1;
        max = Math.max(temp,max);
        pathCheck.add(stack.peek());
      }
    }
    return max;
  }
  
   public static int DirMAX (String S){
    int max =0,curLen=0;
    if (S == null ||S.length()==0) return 0;
    String [] lines = S.split("\n");//split by \n
    Stack<String> stack = new Stack <String>();
    stack.push("");//root
    HashSet<String> pathCheck = new HashSet<String>();
    //which folder contains file,so won't contain duplicate path
    for (int i =0;i<lines.length;i++)
    {
      int level = 0;
      while (level <lines[i].length()&&lines[i].charAt(level)==' ')
      {
         level++;
      }
      boolean fileCheck = check1(lines[i]);
      while (!stack.peek().equals("")&&level+1<stack.size())
      {
        String currentLevel = stack.pop();
        curLen -=(currentLevel.length()+1);
      }//get to the level just above current level
      if (!fileCheck)
      {
        stack.add(lines[i].trim());
        curLen +=(lines[i].trim().length()+1);
      }
      else if (!pathCheck.contains(stack.peek()))
      {
        max = Math.max(curLen,max);
        pathCheck.add(stack.peek());
      }
    }
    return max;
  }
  
  public static int Dir (String S){
    int result =0,curLen=0;
    if (S == null ||S.length()==0) return 0;
    String [] lines = S.split("\n");//split by \n
    Stack<String> stack = new Stack <String>();
    stack.push("");//root
    HashSet<String> pathCheck = new HashSet<String>();
    //which folder contains file,so won't contain duplicate path
    for (int i =0;i<lines.length;i++)
    {
      int level = 0;
      while (level <lines[i].length()&&lines[i].charAt(level)==' ')
      {
         level++;
      }
      boolean fileCheck = check1(lines[i]);
      while (!stack.peek().equals("")&&level+1<stack.size())
      {
        String currentLevel = stack.pop();
        curLen -=(currentLevel.length()+1);
      }//get to the level just above current level
      if (!fileCheck)
      {
        stack.add(lines[i].trim());
        curLen +=(lines[i].trim().length()+1);
      }
      else if (!pathCheck.contains(stack.peek()))
      {
        result += curLen;
        pathCheck.add(stack.peek());
      }
    }
    return result;
  }
  public static boolean check1(String s)
  {
    String check = s.trim();
    int cut = 0;
    for (int i = 0;i<check.length();i++)
    {
      if (check.charAt(i)=='.')
      {
        cut = i;
        break;
      }
    }
    String ans = check.substring(cut);
    return ans.equals(".jpeg") || ans.equals(".gif")||ans.equals(".png");
  }
 
}


