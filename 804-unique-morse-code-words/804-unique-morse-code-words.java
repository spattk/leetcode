class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        for(String word: words){
            String temp = "";
            for(char ch: word.toCharArray()){
                temp += codes[ch-'a'];
            }
            set.add(temp);
        }
        
        return set.size();
    }
}