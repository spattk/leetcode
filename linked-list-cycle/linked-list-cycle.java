/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(true){
            if(fast != null && fast.next != null)
                fast = fast.next.next;
            else {
                fast = null;
            }
            slow = slow.next;
            
            if(slow == fast && slow!=null)
                return true;
            
            if(fast == null || slow == null)
                return false;
        }
    }
}