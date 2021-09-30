class Solution {
    HashMap<Integer, List<Integer>> map;
    public boolean isCyclic(int i, boolean[] visited, boolean[] recStack){
        if (recStack[i])
            return true;
 
        if (visited[i])
            return false;
             
        visited[i] = true;
 
        recStack[i] = true;
        
        List<Integer> children = map.get(i);
         
        for (Integer c: children)
            if (isCyclic(c, visited, recStack))
                return true;
                 
        recStack[i] = false;
 
        return false;
    }
    
    public boolean canFinish(int n, int[][] pre) {
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];
        map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int [] ele: pre){
            List<Integer> list = map.get(ele[1]);
            list.add(ele[0]);
            map.put(ele[1], list);
        }
        
        for(int i=0;i<n;i++)
            System.out.println(map.get(i));
        
        for (int i = 0; i < n; i++)
            if (isCyclic(i, visited, recStack))
                return false;
 
        return true;
    }
}