class Solution {
    
    private int dist(int x, int y){
        return (int)Math.pow(x,2) + (int)Math.pow(y,2);
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->dist(q[0], q[1]) - dist(p[0], p[1]));
        for(int[] arr: points){
            pq.add(new int[]{arr[0], arr[1]});
            
            if(pq.size() > k)
            pq.poll();
        }
        
        
        
        int[][] result = new int[k][2];
        int c = 0;
        for(int[] temp: pq){
            result[c++] = temp;
        }
        
        return result;
    }
}