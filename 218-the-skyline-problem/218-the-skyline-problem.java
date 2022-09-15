class Solution {
    
    class Node {
        int p, ht;
        char type;
        
        Node(int p, int ht, char t){
            this.p = p;
            this.ht = ht;
            type = t;
        }
    }
    
    public static int customCompare(Node n1, Node n2){
        int val = Integer.compare(n1.p, n2.p);
        if(val != 0)
            return val;
        
        if(n1.type == n2.type){
            if(n1.type == 's'){
                return Integer.compare(n2.ht, n1.ht);
            } else {
                return Integer.compare(n1.ht, n2.ht);
            }
        } else {
            if(n1.type == 's'){
                 return -1;
            } else {
                return 1;
            }
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Node> list = new ArrayList<>();
        
        for(int []ele: buildings){
            list.add(new Node(ele[0], ele[2], 's'));
            list.add(new Node(ele[1], ele[2], 'e'));
        }
        Collections.sort(list, Solution::customCompare);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q)->q-p);
        pq.add(0);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(Node node: list){
            int prevMax = pq.peek();
            int currMax;
            if(node.type == 's'){
                pq.add(node.ht);
                currMax = pq.peek();
                if(currMax != prevMax){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node.p);
                    temp.add(node.ht);
                    result.add(new ArrayList<>(temp));
                }
            } else {
                pq.remove(node.ht);
                currMax = pq.peek();
                if(currMax != prevMax){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node.p);
                    temp.add(pq.peek());
                    result.add(temp);
                }
            }
        }
        
        return result;
    }
}