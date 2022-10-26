class Solution {
	//next index of j
	int j = 0, n;
	int count = 0;
	public boolean getPosition(String source, String target){
		boolean found = false;
		int i=0;
		int sn = source.length();
		while(i<sn && j<n){
			if(source.charAt(i) == target.charAt(j)){
				i++;
				j++;
				found = true;
			}
			else {
				i++;
			}
		}

		return found;
	}

	public boolean isPossible(String source, String target){
		int[] chs1 = new int[26];
		int[] chs2 = new int[26];

		for(char ch: source.toCharArray()){
			chs1[ch-'a']++;
		}

		for(char ch: target.toCharArray()){
			chs2[ch-'a']++;
		}

		for(int i=0; i<26; i++){
			if(chs1[i] == 0 && chs2[i] != 0)
				return false;
		}

		return true;
	}
	
    	public int shortestWay(String source, String target) {
            n = target.length();
     		if(!isPossible(source, target)){
			return -1;
		}
		
		j = 0;
		while(j < n) {
			if(!getPosition(source, target)){
				return -1;
			}
			count++;
		}

		return count;
		
    	}
}


