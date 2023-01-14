class Solution {
    int[] parent;
    
    public int findParent(int a){
        if(parent[a] != a){
            parent[a] = findParent(parent[a]);
        }
        return parent[a];
    }
    
    public void union(int a, int b){
        int pa = findParent(a);
        int pb = findParent(b);
        
        if(pa != pb){
            if(pa < pb){
                parent[pb] = pa;
            }
            else {
                parent[pa] = pb;
            }
        }
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        parent = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<n; i++){
            union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch: baseStr.toCharArray()){
            int p = findParent(ch-'a');
            sb.append((char)('a' + p));
        }
        
        return sb.toString();
    }
}