class Solution {
    public int lengthOfLongestSubstring(String s) {
     	Map<Character, Integer> map = new HashMap<>();
		int start = 0;
	    int n = s.length();	
		char[] chs = s.toCharArray();
		int maxLen = 0;
		for(int i=0; i<n; i++){
			if(map.get(chs[i]) != null){
				start = Math.max(start, map.get(chs[i]) + 1);
			}

			maxLen = Math.max(maxLen, i - start + 1);	
			map.put(chs[i], i);
		}

		return maxLen;
        
    	}
}

