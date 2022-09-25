class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        int total = 0;
        boolean odd = false;
        for(char key: map.keySet()){
            if(map.get(key) % 2== 0){
                total += map.get(key);
            } else {
                total += map.get(key) - 1;
                odd = true;
            }
        }
        
        return odd== true? total + 1 : total;
    }
}