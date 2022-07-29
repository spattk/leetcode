class Solution {
    
    public int findParent(int[] parent, int p){
        if(parent[p] != p){
            parent[p] = findParent(parent, parent[p]);
        }
        return parent[p];
    }
    
    public void union(int u, int v, int[] parent){
        int pu = findParent(parent, u);
        int pv = findParent(parent, v);
        
        if(pu != pv){
            parent[pu] = pv;
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailMap = new HashMap<>();
        int n = accounts.size();
        int[] parent = new int[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        for(int i=0;i<n;i++){
            List<String> currList = accounts.get(i);
            for(int j=1; j< currList.size(); j++){
                if(emailMap.get(currList.get(j))!= null){
                    union(emailMap.get(currList.get(j)), i, parent);
                } else {
                    emailMap.put(currList.get(j), i);
                }
            }
        }
        
        Map<Integer, Set<String>> merged = new HashMap<>();
        for(int i=0;i<n;i++){
            int p = findParent(parent, i);
            Set<String> curr = merged.getOrDefault(p, new HashSet<>());
            List<String> currList = accounts.get(i);
            for(int j=1; j< currList.size(); j++){
                curr.add(currList.get(j));
            }
            merged.put(p, curr);
        }
        
        List<List<String>> finalResult = new ArrayList<>();
        
        for(int key: merged.keySet()){
            Set<String> curr = merged.get(key);
            List<String> currList = new ArrayList<>(curr);
            Collections.sort(currList);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(key).get(0));
            temp.addAll(currList);
            finalResult.add(new ArrayList<>(temp));
        }
        
        return finalResult;
    }
}