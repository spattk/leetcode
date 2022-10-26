class Solution {
	//return maxHeight of shelf starting from idx
	int n;
	int maxWidth;
    Map<String, Integer> dp;
	public int solve(int[][] books, int idx, int widthLeft, int height){
		if(idx == n){
			return height;
		}
        
        int w = books[idx][0];
        int h = books[idx][1];

        String key = idx + "," + widthLeft + "," + height;
        if(dp.get(key)!= null)
            return dp.get(key);
        
        //next level
        int ans = solve(books, idx+1, maxWidth - w, h) + height;
        
        //same level
		if(w<=widthLeft){
			ans = Math.min(ans, solve(books, idx+1, widthLeft - w, Math.max(height, h)));
		}
              
        dp.put(key, ans);
        return ans;
    
	}
    public int minHeightShelves(int[][] books, int shelfWidth) {
    	n = books.length;
        dp = new HashMap<>();
		maxWidth = shelfWidth;
		return solve(books, 0, shelfWidth, 0);
    }
}
