class Solution {
    public int wordsTyping(String[] sen, int rows, int cols) {
     		//the main goal is to get the no of times the whole sentence is repeated starting from ith position
	
		int n = sen.length;
		int[] times = new int[n];
		int[] nextIndex = new int[n];
		for(int i=0; i<n; i++){
			int curr = i;
			int time = 0;
			int currLen = 0;
	
			while(currLen + sen[curr].length() <= cols){
				currLen += sen[curr].length() + 1;
				curr++;

				if(curr == n){
					time++;
					curr = 0;
				}
			}

			nextIndex[i] = curr;
			times[i] = time;
			
		}

		int ans = 0, curr = 0;
		for(int i=0; i<rows; i++){
			ans += times[curr];
			curr = nextIndex[curr];
		}

		return ans;
    }
}
