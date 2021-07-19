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
    
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        
        //2 nodes
        if (head.next.next == null) {
            ListNode temp = head.next;
            head.next = null;
            temp.next = head;
            
            return temp;
        }
        
        
        //3 or more
        ListNode prev, curr, after;
        prev = null;
        curr = head;
        after = head.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = after;
            if (after !=null)
                after = after.next;
        }
        
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        
        int num = k;
        
        ListNode first = new ListNode(0);
        ListNode firstHead = first;
        ListNode mid;
        ListNode last;
        
        ListNode temp = head;
        while(num-->1){
            temp = temp.next;
        }
        
        last = temp.next;
        temp.next = null;
        mid = head;
        
        while(true){
            ListNode rev = reverse(mid);
            System.out.println("r" + rev.val);
            first.next = rev;
            while(first.next != null){
                first = first.next;
            }
            System.out.println("f" + first.val);
            ListNode temp1 = last;
            ListNode temphead = last;
            num = k;
            while(num-->1 && temp1 != null){
                System.out.println(num);
                temp1 = temp1.next;
            }
            //reached the last set
            if (temp1 == null){
                System.out.println("null");
                first.next = last;
                return firstHead.next;
            }
            
            
            last = temp1.next;
            temp1.next = null;
            mid = temphead;
        }
    }
}