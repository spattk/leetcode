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
    
    public ListNode findNode(ListNode head, int pos){
        int k = 1;
        ListNode temp = head;
        while(k < pos){
            temp = temp.next;
            k++;
        }
        return temp;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null, curr = head, after=head.next;
        if(curr == null)
            return null;
        
        if(after == null)
            return curr;
        
        while(curr != null){
            
            curr.next = prev;
            
            prev = curr;
            curr = after;
            
            if(after != null)
                after = after.next;
        }
        
        return prev;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == 1){
            
            ListNode end = findNode(head, right);
            ListNode secondHalf = end.next;
            end.next = null;
            
            ListNode reversed = reverseList(head);
            
            ListNode temp = reversed;
            while(temp.next!=null)
                temp = temp.next;
            
            temp.next = secondHalf;
            return reversed;
            
        } else {
            ListNode begin = findNode(head, left);
            ListNode beforeBegin = findNode(head, left-1);
            ListNode end = findNode(head, right);
            ListNode secondHalf = end.next;
            end.next = null;
            beforeBegin.next = null;
            
            ListNode reversed = reverseList(begin);
            beforeBegin.next = reversed;
            
            ListNode temp = reversed;
            while(temp.next!=null)
                temp = temp.next;
            
            temp.next = secondHalf;
            return head;
            
        }
    }
}