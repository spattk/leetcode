class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i=0, j = 0, n = s.length();
        int max = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < n){
            char ch = s.charAt(j);
            if(map.get(ch) == null || map.get(ch) == 0){
                map.put(ch,1);
                count++;
                while(count > 2){
                    ch = s.charAt(i);
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch) == 0)
                        count--;
                    i++;
                }
                
            } else {
                map.put(ch, map.get(ch) + 1);
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        max = Math.max(max, j-i);
        
        return max;
    }
}