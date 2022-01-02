class Solution {
    static class Node {
        String s;
        Double val;
        
        Node(String s, Double v){
            this.s = s;
            this.val = v;
        }
        
        public String toString(){
            return this.s + "::" + this.val;
        }
    }
    Map<String, Set<Node>> adj;
    
    public double solve(String a, String b){
        // System.out.println(">>>" + a + ":" + b);
        // System.out.println(adj);
        if(a.equals(b)){
            if(adj.get(a) != null)
                return 1.0;
            else
                return -1.0;
        }
        
        if(adj.get(a) == null){
            return -1.0;
        }
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(a);
        q.add(new Node(a, 1.0));
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.s.equals(b))
                return temp.val;
            
            for(Node neigh: adj.getOrDefault(temp.s, new HashSet<>())){
                if(!visited.contains(neigh.s)){
                    visited.add(neigh.s);
                    q.add(new Node(neigh.s, temp.val* neigh.val));
                }
            }
        }
        
        return -1.0;
        
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adj = new HashMap<>();
        
        int n = equations.size();
        for(int i=0;i<n;i++){
            List<String> eq = equations.get(i);
            Set<Node> temp1 = adj.getOrDefault(eq.get(0), new HashSet<>());
            temp1.add(new Node(eq.get(1), values[i]));
            adj.put(eq.get(0), temp1);
            
            Set<Node> temp2 = adj.getOrDefault(eq.get(1), new HashSet<>());
            temp2.add(new Node(eq.get(0), 1.0/values[i]));
            adj.put(eq.get(1), temp2);
        }
        
        int l = queries.size();
        double[] result = new double[l];
        for(int i=0;i<l;i++){
            result[i] = solve(queries.get(i).get(0), queries.get(i).get(1));
        }
                      
        return result;           
    }
}