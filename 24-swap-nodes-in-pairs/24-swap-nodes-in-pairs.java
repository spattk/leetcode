/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    //swap and returns the head
    public ListNode swapUtil(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head;
        ListNode next = head.next;
        
        ListNode second = next.next;
        next.next = curr;
        curr.next = swapUtil(second);
        return next;
    }
    
    public ListNode swapPairs(ListNode head) {
        return swapUtil(head);
    }
}