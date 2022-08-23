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
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public boolean isPalindrome(ListNode first, ListNode second) {
        while(first!= null && second != null){
            if(first.val != second.val)
                return false;
            
            first = first.next;
            second = second.next;
        }    
        
        if(first != null)
            return false;
        
        if(first == null && second == null)
            return true;
        
        if(second != null && second.next == null){
            return true;
        }
        
        return false;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head, prev = null, next = head;
        while(curr != null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        
        mid.next = null;
        
        return isPalindrome(head, reverse(second));
    }
}