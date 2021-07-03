class Solution {
    class Node {
        int ele;
        int diff;
        
        Node(int e, int d){
            this.ele = e;
            this.diff = d;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.diff - a.diff);
        for(int num: arr){
            int currDiff = Math.abs(x-num);
            if (pq.size() < k){
                pq.add(new Node(num, currDiff));
            } else{
                if (pq.peek().diff == currDiff) {
                    if (pq.peek().ele > num){
                        pq.poll();
                        pq.add(new Node(num, currDiff));
                    } else{
                        continue;
                    }
                } else if (pq.peek().diff < currDiff) {
                    continue;
                } else {
                    pq.poll();
                    pq.add(new Node(num, currDiff));
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(Node node: pq){
            result.add(node.ele);
        }
        
        Collections.sort(result);
        return result;
    }
}