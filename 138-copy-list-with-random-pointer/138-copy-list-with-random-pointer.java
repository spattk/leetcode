/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Integer, Node> indexToNodeMap = new HashMap<>();
        Map<Node, Node> oldToNewMap = new HashMap<>();
        
        Node temp = head;
        int k = 0;
        while(temp != null){
            indexToNodeMap.put(k, temp);
            oldToNewMap.put(temp, new Node(temp.val));
            
            temp = temp.next;
            k++;
        }
        
        // System.out.println(indexToNodeMap);
        
        temp = head;
        Node newHead = new Node(0);
        Node newTemp = newHead;
        while(temp != null){
            Node curr = oldToNewMap.get(temp);
            curr.random = oldToNewMap.get(temp.random);
            newTemp.next = curr;
            newTemp = newTemp.next;
            
            temp = temp.next;
        }
        
        return newHead.next;
    }
}