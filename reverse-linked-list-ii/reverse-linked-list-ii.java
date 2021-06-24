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
    
    public ListNode reverse(ListNode node){
        
        
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        ListNode temp = node;
        while(temp!=null){
            // System.out.println(temp.val + " ^^^^");
            temp = temp.next;
        }
        
        return node;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode f = new ListNode(0);
        f.next = head;
        head = f;
        
        if (left == right){
            return head.next;
        }
        
        ListNode temp = head;
        ListNode start = head;
        ListNode mid = head;
        ListNode end = head;
        while(temp != null){
            if (i == left){
                start = temp;
                mid = temp.next;
            } else if (i == right+1){
                
                end = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
            // mid = mid.next;
            i++;
        
        }
        
        //join
        start.next = reverse(mid);
        ListNode t2 = mid;
        while(t2.next != null){
            // System.out.println("here" + t2.val);
            t2 = t2.next;
        }
        t2.next = end;
        
        
        return head.next;
    }
}