import java.io.*;
import java.util.*;
import java.nio.file.*

public class Solution
{
    int speed (int arg1, int arg2)
    {
     return arg1*arg2;
    }
  public List<String> dinosaur(String [] file1,String [] file2)
  {
      Map<String,Integer> name_arg1 = new HashMap<>();
      for (String s :file2)//all string in file  split by \n
      {
          String ss [] = s.trim().split(",\\s*");
          if (ss[2].equals("towLegs"))
          {
              name_arg1.put(ss[0],Integer.parseInt(ss[1]));
          }
          }
     Map<String,Integer> name_speed = new HashMap<>();
     for (String s :file1)
     {
     if(name_arg1.containsKey(ss[0]))
     {// if contain name (two legs drgaon) put speed legs(from map.get)*speed to the name key 
        name_speed.put(ss[0],speed(name_arg1.get(ss[0]),Integer.parseInt(ss[1]));
     }
     }
 Queue<String> maxheap = new PriorityQueue<>((x,y)->name_speed.get(y)-name_speed.get(x));
 maxheap.addAll(name_speed.KeySet());//add all key set to maxheap
 //but priorityqueue define use their get value to compare 
 //max will be first 
 List<String> result = new ArrayList<>();
 while (!maxheap.isEmpty())
 {
     result.add(maxheap.poll());//add from large to small
 }
 return result;
      }
 

 }
  }
public static void main(String [] args)
 {
     String [] file1 = new String []
     {
         "d1, 30",
         "d2, 40",
         "d3, 30"
     };
     String [] file2 = new String []
     {
         "d1, 10,twoLegs",
         "d2, 10,twoLegs",
         "d3, 10,twoLegs",
         "d4, 30,fourLegs",
     };
Solution ss =new Solution();
 for (String name :ss.dinosaur(file1,file2))
 {
     System.out.println(name);
 }
 return;
 }