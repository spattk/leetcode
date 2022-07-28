class Solution {
    
    public void generateCharMap(int[][] charMap, String str, int i){
        for(char ch: str.toCharArray())
            charMap[i][ch-'a']++;
    }
    
    public boolean isAnagram(int[] c1, int [] c2){
        for(int i=0; i<26; i++){
            if(c1[i] != c2[i])
                return false;
        }
        
        return true;
    }
    
    public void generateList(List<List<String>> result, Map<Integer, Set<Integer>> map, int n, String[] strs){
        
        
        
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<n;i++)
            visited.add(i);
        
        for(int key: map.keySet()){
            visited.remove(key);
            List<String> temp = new ArrayList<>();
            temp.add(strs[key]);
            for(int ele: map.get(key)){
                visited.remove(ele);
                temp.add(strs[ele]);
            }
            result.add(new ArrayList<>(temp));
        }
        
        
        
        for(int i: visited){
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            result.add(new ArrayList<>(temp));
        }
        
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int[][] charMap = new int[n][26];
        for(int i=0; i<n; i++){
            String str = strs[i];
            generateCharMap(charMap, str, i);
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        int[] parent = new int[n];
        for(int i=0; i<n ;i++)
            parent[i] = i;
        
        for(int i=0; i<n; i++){
            if(parent[i] != i)
                continue;
            
            for(int j=i+1; j<n; j++){
                if(isAnagram(charMap[i], charMap[j])){
                    parent[j] = i;
                    Set<Integer> set = map.getOrDefault(i, new HashSet<>());
                    set.add(j);
                    map.put(i, set);
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        generateList(result, map, n, strs);
        return result;
        
    }
}