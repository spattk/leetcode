class Solution {
    
    int[] rank;
    int[] parent;
    
    
    public void union(char c1, char c2){
        int p1 = findParent(c1);
        int p2 = findParent(c2);
        
        if(p1 != p2){
            int r1 = rank[p1];
            int r2 = rank[p2];
            
            if(r1 > r2){
                parent[p2] = p1;
                
            } else if(r1 < r2){
                parent[p1] = p2;
                
            } else {
                parent[p2] = p1;
                rank[p1]++;
            }
            
        }
    }
    
    public int findParent(char ch){
        int idx = ch - 'a';
        if(parent[idx] != idx){
            parent[idx] = findParent((char)('a' + parent[idx]));
        }
        
        return parent[idx];
    }
    
    public void processEquality(String[] equations){
        for(String eq: equations){
            char ch1 = eq.charAt(0);
            char ch2 = eq.charAt(3);
            
            char ch3 = eq.charAt(1);
            
            if(ch3 == '=' && ch1 != ch2){
                union(ch1, ch2);
            }
        }
    }
    
    public boolean processInequality(String[] equations){
        for(String eq: equations){
            char ch1 = eq.charAt(0);
            char ch2 = eq.charAt(3);
            
            char ch3 = eq.charAt(1);
            
            if(ch3 == '!' && ch1 == ch2){
                 return false;
            }
            
            if(ch3 == '!') {
                int p1 = findParent(ch1);
                int p2 = findParent(ch2);
                
                if(p1 == p2)
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean equationsPossible(String[] equations) {
        
        rank = new int[26];
        parent = new int[26];
        
        for(int i=0; i<26; i++)
            parent[i] = i;
        
        processEquality(equations);
        return processInequality(equations);
    }
}