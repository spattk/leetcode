class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, n = s.length();
        if(n == 0)
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        while(i < n){
            char ch = s.charAt(i);
            if(map.get(ch) != null){
                max = Math.max(max, i-start);
                //to make sure, start doesn't go backwards.
                start = Math.max(start, map.get(ch)+1);
            }
            map.put(ch, i);
            i++;
        }
        max = Math.max(max, i - start);
        return max;
    }
}