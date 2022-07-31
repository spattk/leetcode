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
    
    public ListNode mergeList(ListNode first, ListNode list){
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(first != null && list != null){
            if(first.val <= list.val){
                result.next = first;
                first = first.next;
            } else {
                result.next = list;
                list = list.next;
            }
            result = result.next;
        }
        
        
        if(first != null){
            result.next = first;
        }
        
        if(list != null)
            result.next = list;
        
       return head.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        
        if(n == 0)
            return null;
        
        int i = 0;
        ListNode result = lists[0];
        ListNode resultHead = result;
        
        for(i=1; i<n; i++){
            result = mergeList(result, lists[i]);
            resultHead = result;
        }
        
        return resultHead;
    }
}