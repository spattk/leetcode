class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int n = s.length();
        int start = 0, i;
        for(i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map.get(ch) != null){
                //duplicate
                max = Math.max(max, i-start);
                start = Math.max(start, map.get(ch)+1);
            }
            map.put(ch, i);
        }
        max = Math.max(max, i-start);
        return max;
    }
}