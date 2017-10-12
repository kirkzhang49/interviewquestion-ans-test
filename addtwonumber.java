
public class test{

  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 
     public static void main(String []args){
        ListNode input1 = new ListNode(1);
        input1.next = new ListNode(5);
        ListNode input2 = new ListNode(3);
        input2.next = new ListNode(7);
        ListNode result = addTwoNumber(input1,input2);
        System.out.println(result.next.next.val);
     }
       
    public static ListNode addTwoNumber(ListNode l1,ListNode l2)
    {
       ListNode first = l1;
       ListNode second = l2;
       ListNode dummy = new ListNode(0);
       ListNode record = dummy;
       int sum=0;
       while (first!=null||second!=null)
       {
            sum/=10;
           if (first!=null)
           {
               sum+=first.val;
               first = first.next;
           }
           if (second!=null)
           {
               sum +=second.val;
               second = second.next;
           }
           record.next = new ListNode(sum%10);
           record=record.next;
       }
       if (sum/10==1) record.next = new ListNode(1);
       return dummy.next;
    }
    
}