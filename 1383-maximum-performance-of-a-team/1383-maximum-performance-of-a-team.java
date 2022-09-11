class Solution {
    class Node {
        int speed;
        int eff;
        
        Node(int s, int f){
            this.speed = s;
            this.eff = f;
        }
    }
    
    public int processList(List<Node> list, int k){
        PriorityQueue<Node> pq = new PriorityQueue<>((p,q) -> p.speed - q.speed);
        long maxPerf = 0;
        long mod = (long) (1e9 + 7);
        long currSpeedSum = 0;
        long intermittent = 0;
        
        for(Node ele: list){
            currSpeedSum += ele.speed;
            
            while(!pq.isEmpty() && pq.size() > k-1){
                Node temp = pq.poll();
                currSpeedSum -= temp.speed;
            }
            
            maxPerf = Math.max(maxPerf, currSpeedSum * ele.eff);
            
            pq.add(ele);
        }
        
        return (int)(maxPerf % mod);
    }
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Node> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Node(speed[i], efficiency[i]));
        }
        
        Collections.sort(list, (p,q)-> q.eff - p.eff);
        
        return processList(list, k);
    }
}