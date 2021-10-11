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
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode head = null;
        if(l1 == null && l2 == null){
            return node;
        }
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                if (node == null){
                    node = new ListNode(l1.val);
                    head = node;
                } else {
                    node.next = new ListNode(l1.val);
                    node = node.next;
                }
                
                l1 = l1.next;
            } else {
                if (node == null){
                    node = new ListNode(l2.val);
                    head = node;
                } else {
                    node.next = new ListNode(l2.val);
                    node = node.next;
                }
                
                l2 = l2.next;
            }
        }
        
        while( l1 != null){
            if(node == null){
                node = new ListNode(l1.val);
                head = node;
            } else {
                node.next = new ListNode(l1.val);
                node = node.next;
            }
            l1 = l1.next;
        }
        
        while( l2 != null){
            if(node == null){
                node = new ListNode(l2.val);
                head = node;
            } else {
                node.next = new ListNode(l2.val);
                node = node.next;
            }
            
            l2 = l2.next;
        }
        
        return head;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        else if (lists.length == 1){
            return lists[0];
        }
        
        int n = lists.length;
        ListNode result = mergeTwoLists(lists[0], lists[1]);
        for(int i=2;i<n;i++){
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }
}