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
                //start should come fast
                //-1 mean no change in ordering
                 return -1;
            } else {
                //reverse the ordering
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
        
        // PriorityQueue<Integer> pq = new PriorityQueue<>((p,q)->q-p);
        //increasing order
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        pq.put(0,1);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(Node node: list){
            int prevMax = pq.lastEntry().getKey();
            int currMax;
            if(node.type == 's'){
                pq.put(node.ht, pq.getOrDefault(node.ht, 0) + 1);
                currMax = pq.lastEntry().getKey();
                if(currMax != prevMax){
                    result.add(Arrays.asList(node.p, node.ht));
                }
            } else {
                
                pq.put(node.ht, pq.getOrDefault(node.ht, 0)-1);
                if(pq.get(node.ht) == 0){
                    pq.remove(node.ht);
                }
                currMax = pq.lastEntry().getKey();
                if(currMax != prevMax){
                    result.add(Arrays.asList(node.p, pq.lastEntry().getKey()));
                }
            }
        }
        
        return result;
    }
}