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
    
    ListNode[] findMiddle(ListNode head){
        if(head.next == null){
            return new ListNode[]{null, head};
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == null || fast.next == null){
                return new ListNode[]{prev, slow};
            }
        }
        
        return new ListNode[]{null, null};
    }
    
    public ListNode deleteMiddle(ListNode head) {
        ListNode [] nodes = findMiddle(head);
        ListNode prev = nodes[0];
        ListNode curr = nodes[1];
        
        if(prev == null){
            return null;
        }
        
        prev.next = curr.next;
        return head;
    }
}