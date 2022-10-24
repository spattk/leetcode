class Solution {
    
    public boolean isValidSelf(List<String> arr, int idx){
        boolean[] currVector = new boolean[26];
        for(char ch: arr.get(idx).toCharArray()){
			if(currVector[ch-'a'])
				return false;

			currVector[ch-'a'] = true;
		}
		return true;
    }
    
	public boolean isPossible(List<String> arr, int idx, boolean[] bitVector){
		for(char ch: arr.get(idx).toCharArray()){
			if(bitVector[ch-'a'])
				return false;
		}
		return true;
	}

	public void addToVisited(List<String> arr, int idx, boolean[] bitVector){
		for(char ch: arr.get(idx).toCharArray()){
			bitVector[ch-'a'] = true;
		}
	}

	public void removeFromVisited(List<String> arr, int idx, boolean[] bitVector){
		for(char ch: arr.get(idx).toCharArray()){
			bitVector[ch-'a'] = false;
		}
	}
	
    Map<Pair<Integer, String>, Integer> dp;
    
    public int getCount(boolean[] bitVector){
        int count = 0;
        for(boolean ch: bitVector){
            if(ch)
                count++;
        }
        
        return count;
    }
    
//     public String getKey(boolean[] bitVector){
//         StringBuilder sb = new StringBuilder();
//         for(boolean ch: bitVector){
//             if(ch){
//                 sb.append("1");
//             } else {
//                 sb.append("0");
//             }
//         }
        
//         return sb.toString();
//     }
    
	public int solve(List<String> arr, int idx, boolean[] bitVector){
		if(idx == arr.size()){
			return getCount(bitVector);
		}

		// if(dp[idx] != null){
		// 	return getCount(bitVector) + dp[idx];
		// }
        // String key = getKey(bitVector);
        // Pair<Integer, String> pair = new Pair(idx, key);
        // if(dp.get(pair) != null)
        //     return dp.get(pair);

		int result = 0;
		if(isValidSelf(arr,idx) && isPossible(arr, idx, bitVector)){
			addToVisited(arr, idx, bitVector);
			int s1 = solve(arr, idx+1, bitVector);
			
            removeFromVisited(arr, idx, bitVector);			

			int s2 = solve(arr, idx+1, bitVector);

			result = Math.max(s1, s2);
		}
		else {
			result = solve(arr, idx+1, bitVector);
		}

        // dp.put(pair, result);
		return result;
	}	

    public int maxLength(List<String> arr) {
		dp = new HashMap<>();
        boolean[] bitVector = new boolean[26];
    	return solve(arr, 0, bitVector);
    }
}


