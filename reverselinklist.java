import java.io.*;
import java.util.*;


public class test {
  public static void main(String[] args) {
    
    ListNode input = new ListNode(3);
    input.next = new ListNode(5);
    input.next.next = new ListNode(7);
    input.next.next.next = new ListNode(2);
    ListNode output = input;
     while (output!=null)
    {
        System.out.println(output.val);
        output = output.next;
    }
    System.out.println("reversed the links now");
    ListNode result = reverseList(input);
    while (result!=null)
    {
        System.out.println(result.val);
        result = result.next;
    }

  }
  public static class ListNode
  {
      int val;
      ListNode next;
      ListNode(int x) {val = x;}
  }
     public static ListNode reverseList(ListNode head)
     {
         ListNode newNode =null;
         while (head!=null)
         {
             ListNode next = head.next;//record next
             head.next = newNode;//link reverse postion
             newNode = head;//next reverse position
             head= next;//to  next position 
         }
         return newNode;//from last reverse link to previous
     }

}


