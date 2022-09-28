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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        
        if(n == 1 && head.next == null){
            return head.next;
        }
        
        ListNode first = head, second = head, prev = head;
        while(n-->0 && second != null){
            second = second.next;
        }
        
        if(n > 0){
            return head;
        }
        
        if(second == null){
            return head.next;
        }
        
        
        while(second != null){
            second = second.next;
            prev = first;
            first = first.next; 
        }
        prev.next = first.next;
        
        
        return head;
        
    }
}