class Solution {
    
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> rank = new HashMap<>();
   
    
    public String findParent(String str){
        if(!parent.get(str).equals(str)){
            parent.put(str, findParent(parent.get(str)));
        }
        
        return parent.get(str);
    }
    
    public boolean union(String s1, String s2){
        
        if(s1.equals(s2))
            return true;
        
        String p1 = parent.get(s1);
        String p2 = parent.get(s2);
        
        int r1 = rank.get(p1);
        int r2 = rank.get(p2);
        
        if(!p1.equals(p2)){
            
            if(r1 < r2) {
                parent.put(p1, p2);
            } else if(r1 > r2){
                parent.put(p2, p1);
            } else {
                parent.put(p2, p1);
                rank.put(p1, rank.get(p1) + 1);
            }
            
            return true;
        }
        
        return false;
    }
    
    public void init(String[] strs){
        for(String str: strs){
            parent.put(str, str);
            rank.put(str, 0);
        }
    }
    
    public boolean isSimilar(String s1, String s2){
        
        // System.out.println("P " + s1 + " " + s2);
        if(s1.length() != s2.length())
            return false;
        
        if(s1.equals(s2))
            return true;
        
        int n = s1.length();
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        
        Integer d1 = null, d2 = null, count = 0;
        for(int i=0; i<n; i++){
            if(chs1[i] != chs2[i]){
                count++;
                if(d1 == null){
                    d1 = i;
                } else {
                    d2 = i;
                }
            }
            
            if(count > 2){
                return false;
            }
        }
        
        
        return count == 2 && chs1[d1] == chs2[d2];
    }
    
    public int numSimilarGroups(String[] strs) {
        init(strs);
        int n = strs.length;
        int count = n;
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(isSimilar(strs[i], strs[j])){
                    if(union(strs[i], strs[j]))
                        count--;
                }
            }
        }
        
        return count <=0 ? 1 :  count;
    }
}