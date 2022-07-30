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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carry = 0;
        while(carry != 0 || l1 != null || l2 != null){
            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            // System.out.println(val);
            int add = val % 10;
            carry = val/10;
            
            temp.next = new ListNode(add);
            temp = temp.next;
            
            if(l1 != null)
                l1 = l1.next;
            
            if(l2 != null)
                l2 = l2.next;
        }
        
        return head.next;
    }
}