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
    
    public ListNode findMid(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public void mergeList(ListNode h1, ListNode h2){
        ListNode root = h1;
        while(h2 != null){
            ListNode next = h1.next;
            h1.next = h2;
            h1 = h2;
            h2 = next;
        }
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode prev=null, curr = head, next = head;
        while(curr != null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    
    public void reorderList(ListNode head) {
        //Step 1: Break into 2 list from mid.
        //Step 2: Reverse the 2nd list;
        //Step 3: Merge one by one
        
        ListNode mid = findMid(head);
        ListNode reverse = reverse(mid.next);
        mid.next = null;
        mergeList(head, reverse);
    }
}