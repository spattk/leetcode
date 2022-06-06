/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null){
            set.add(tempA);
            tempA = tempA.next;
        }
        
        while(tempB != null){
            if(set.contains(tempB)){
                return tempB;
            }
            tempB = tempB.next;
        }
        
        return null;
    }
}