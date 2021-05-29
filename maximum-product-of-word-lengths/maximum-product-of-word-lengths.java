class Solution {
    public int maxProduct(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length;
        for(String word: words){
            int temp = getInt(word);
            map.put(word, temp);
        }
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if ((map.get(words[i]) & map.get(words[j])) == 0){
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        
        return result;
    }
    
    public int getInt(String word) {
        int num = 0;
        for(int i=0;i<word.length();i++){
            int temp = word.charAt(i) - 'a';
            num |= (1 << temp);
        }
        return num;
    }
}