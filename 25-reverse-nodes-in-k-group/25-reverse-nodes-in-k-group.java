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
    
    public ListNode revList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null, curr = head, next;
        while(curr != null){
            next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode newList, newListHead, curr, currHead, sec = null, rev = null;
        newList = new ListNode(0);
        newListHead = newList;
        
        curr = head;
        currHead = head;
        int count = 1;
        while(curr != null){
            // System.out.println(curr.val);
            curr = curr.next;
            ++count;
            
            if(curr == null){
                newList.next = currHead;
                break;
            }
                
            
            if(count == k){
                sec = curr.next;
                curr.next = null;
                rev = revList(currHead);
                newList.next = rev;
                while(newList.next != null)
                    newList = newList.next;
                
                count = 1;
                curr = sec;
                currHead = sec;
            }
        }
        
        return newListHead.next;
    }
}