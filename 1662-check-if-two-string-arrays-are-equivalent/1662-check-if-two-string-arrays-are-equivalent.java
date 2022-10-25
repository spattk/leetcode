class Solution {
	public String generateWord(String[] word){
		StringBuilder sb = new StringBuilder();
		for(String str: word)
			sb.append(str);

		return sb.toString();
	}

    	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		String s1 = generateWord(word1);
		String s2 = generateWord(word2);
		
		return s1.equals(s2);
    	}
}


