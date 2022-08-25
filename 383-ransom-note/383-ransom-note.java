class Solution {
    
    public void generateWordMap(String str, int [] map){
        for(char ch: str.toCharArray()){
            map[ch-'a']++;
        }
    }
    
    public boolean compare(int[] rMap, int[] mMap){
        for(int i=0; i<26;i++){
            if(rMap[i] > mMap[i])
                return false;
        }
        
        return true;
    }
    
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rMap = new int[26];
        int[] mMap = new int[26];
        
        generateWordMap(ransomNote, rMap);
        generateWordMap(magazine, mMap);
        
        return compare(rMap, mMap);
    }
}