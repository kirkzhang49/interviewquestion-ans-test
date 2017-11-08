public class Solution {//check cycle
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode fast = head, slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
}
}
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
   if (headA==null||headB==null) return null;
      ListNode a = headA;
      ListNode b = headB;
      while (a!=b)
      {
          a=a==null?headB:a.next;
          b=b==null?headA:b.next;
      }
      return a;
}
}