/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = l1, ln2 = l2, head = null, node = null;
        int carry = 0, remainder = 0, sum = 0;
        head = node = new ListNode(0);//start from dummy node
        
        while(ln1 != null || ln2 != null || carry != 0) {//if still have number
            sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;// check for node 1 and 2 add together with carry
            carry = sum / 10;//sum / 10 will be carry
            remainder = sum % 10;//remainder is sum %10
            node = node.next = new ListNode(remainder);//node.next is remainder
            ln1 = (ln1 != null ? ln1.next : null);//check node 1 and 2
            ln2 = (ln2 != null ? ln2.next : null);
        }
        return head.next;
    }
}