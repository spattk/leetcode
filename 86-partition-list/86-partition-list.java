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
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0), after = new ListNode(0), temp = head;
        ListNode tempB = before, tempA = after;
        if(head == null)
            return null;
        
        while(temp != null){
            if(temp.val < x){
                tempB.next = temp;
                tempB = tempB.next;
            } else{
                tempA.next = temp;
                tempA = tempA.next;
            }
            temp = temp.next;
        }
        tempB.next = null;
        tempA.next = null;
        
        // System.out.println(before.next.val + " " + after.next.val);
        
        tempB.next = after.next;
        return before.next;
        
    }
}