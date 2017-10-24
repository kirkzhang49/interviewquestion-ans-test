/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode temp = null;
        int len = 0;
        //base case
        if(head == null || head.next == null)
            return true;
        // use two pointers to locate the middle of the list and also reverse the first half
        while(fast!=null && fast.next!=null){//half of list
            fast = (fast.next).next;
            //reverse the first half of the list
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
            
        }
        // handle odd number of elements
        if(fast!=null){
            slow = slow.next;//assign slow to next skip the middle node
        }
         //iterate over the two lists and check if the elements have same values
        ListNode l1 = prev;
        ListNode l2 = slow;
       
        while(l1!=null && l2!=null && l1.val == l2.val){
            l1 = l1.next;//check both value for half reversed list to see if identical
            l2 = l2.next;
        }
        //if we successfully iterated over all the elements it means the values were same and 
        //hence a palindrome
        return (l1 == null && l2 == null);
    }
}