class Solution {
    class Node {
        double ratio;
        int idx;
        
        Node(double r, int i){
            ratio = r;
            idx = i;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        List<Node> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Node((1.0 * wage[i])/(1.0 * quality[i]), i));
        }
        
        list.sort((a,b)->Double.compare(a.ratio, b.ratio));
        
        //first loop
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(quality[list.get(i).idx]);
            sum += quality[list.get(i).idx];
        }
        
        double minCost = sum * list.get(k-1).ratio;
        
        for(int i=k;i<n;i++){
            pq.add(quality[list.get(i).idx]);
            sum += quality[list.get(i).idx];
            
            if(pq.size() > k){
                sum -= pq.poll();
            }
            
            minCost = Math.min(minCost, sum * list.get(i).ratio);
        }
        
        return minCost;
    }
}