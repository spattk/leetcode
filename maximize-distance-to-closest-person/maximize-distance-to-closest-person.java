class Solution {
    
    class Node {
        int v;
        int dis;
        
        Node(int v, int dis){
            this.v = v;
            this.dis = dis;
        }
    }
    
    public int maxDistToClosest(int[] seats) {
        Queue<Node> q = new LinkedList<>();
        int n = seats.length;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(seats[i] == 1){
                q.add(new Node(i, 0));
                visited[i] = true;
            }
        }
        
        
        
        int max = 0;
        while(!q.isEmpty()){
            Node temp = q.poll();
            // System.out.println("t " + temp.v + " " + temp.dis);
            max = Math.max(max, temp.dis);
            if(temp.v - 1 >=0 && !visited[temp.v-1]){
                q.add(new Node(temp.v-1, temp.dis+1));
                visited[temp.v-1] = true;
            }
            
            if(temp.v + 1 < n && !visited[temp.v+1]){
                q.add(new Node(temp.v+1, temp.dis+1));
                visited[temp.v+1] = true;
            }
        }
        
        return max;
    }
}