class Solution {
    
    class Node {
        int idx;
        int procTime;
        
        Node(int idx, int procTime){
            this.idx = idx;
            this.procTime = procTime;
        }
    }
    
    public static int customCompare(Node n1, Node n2){
        int ret = Integer.compare(n1.procTime, n2.procTime);
        if(ret == 0){
            ret = Integer.compare(n1.idx, n2.idx); 
        }
        
        return ret;
    }
    
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(Solution::customCompare);
        int[][] newTasks = new int[n][3];
        for(int i=0; i<n; i++){
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }
        Arrays.sort(newTasks, (p,q)->Integer.compare(p[0],q[0]));
        int [] ans = new int[n];
        int k = 0;
        
        
        int idx = 0;
        int time = newTasks[0][0];
        
        while(idx < n){
            boolean noChange = true;
            //add to queue
            while(idx< n && newTasks[idx][0] <= time){
                pq.add(new Node(newTasks[idx][2], newTasks[idx][1]));
                idx++;
                noChange = false;
            }
            
            //pickup the lowest processing one
            if(!pq.isEmpty()){
                Node curr = pq.poll();
                ans[k++] = curr.idx;
                time += curr.procTime;
                noChange = false;
            }
            
            if(noChange)
                time = newTasks[idx][0];
            
            // System.out.println(idx);
        }
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            ans[k++] = curr.idx;
        }
        
        return ans;
    }
}