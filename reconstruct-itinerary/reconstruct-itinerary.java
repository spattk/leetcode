class Solution {
    
    Set<String> set;
    Stack<String> st;
    
    public void dfs(Map<String, List<String>> map, String src, List<String> res) {
        // res.add(src);
        st.push(src);
        
        List<String> list = map.getOrDefault(src, new ArrayList<>());
        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            String temp = src + "|" + str + i;
            if (!(set.contains(temp))){
                set.add(temp);
                dfs(map, str, res);
            }
        }
        
        res.add(st.pop());
        
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for(List<String> list: tickets){
            List<String> temp = adj.getOrDefault(list.get(0), new ArrayList<>());
            temp.add(list.get(1));
            adj.put(list.get(0), temp);
        }
        
        //sorted
        for(Map.Entry<String, List<String>> entry : adj.entrySet()){
            List<String> temp = entry.getValue();
            Collections.sort(temp);
            adj.put(entry.getKey(), temp);
            // System.out.println(adj.get(entry.getKey()));
        }
        
        List<String> result = new ArrayList<>();
        set = new HashSet<>();
        st = new Stack<>();
        
        dfs(adj, "JFK", result);
        
        Collections.reverse(result);
        return result;
    }
}