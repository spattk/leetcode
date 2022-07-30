class Solution {
    
    public void generateMap(int[] chars, String word){
        for(char ch: word.toCharArray()){
            chars[ch-'a']++;
        }
    }
    
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] count = new int[26];
        for(int i=0; i< words2.length; i++){
            String str = words2[i];
            int[] temp = new int[26];
            generateMap(temp, str);
            for(int j=0;j<26;j++)
                count[j] = Math.max(count[j], temp[j]);
        }
        
        for(String str: words1){
            int [] temp = new int[26];
            generateMap(temp, str);
            boolean flag = true;
            for(int i=0; i<26; i++){
                if(temp[i] < count[i]){
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                result.add(str);
        }
        
        return result;
    }
}