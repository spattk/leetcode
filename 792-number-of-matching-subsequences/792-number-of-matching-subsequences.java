class Solution {
    
    public int[] generateArray(String s){
        
        int[] res = new int[26];
        for(char ch: s.toCharArray()){
            res[ch-'a']++;
        }
        
        return res;
    }
    
    public boolean isMatch(int[] ar, int [] br){
        for(int i=0;i<26;i++){
            if(ar[i] < br[i])
                return false;
        }
        
        return true;
    }
    
    public boolean isSubseq(String s1, String s2){
        
        int n = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j))
                i++;
            j++;
        }
        return i == n;
    }
    
    
    public int numMatchingSubseq(String s, String[] words) {
        
        Map<String, Boolean> visited = new HashMap<>();
        int [] sMap = generateArray(s);
        
        int count = 0;
        for(String word: words){
            if(visited.get(word)!=null && visited.get(word)){
                count++;
                continue;
            }
            int [] wMap = generateArray(word);
            if(isMatch(sMap, wMap)){
                if(isSubseq(word, s)){
                    count++;
                    visited.put(word, true);
                }
                    
            }
            
            visited.putIfAbsent(word, false);
        }
        
        return count;
    }
}