class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        int maxScore = 0;
        
        int n = tokens.length;
        int i = 0, j = n - 1;
        boolean enter = false;
        
        while(i <= j) {
            while(i<n && power >= tokens[i]) {
                power -= tokens[i];
                i++;
                score += 1;
                maxScore = Math.max(score, maxScore);
                enter = true;
            }
            
            if(j >=0 && score > 0){
                power += tokens[j];
                j--;
                score -= 1;
                enter = true;
            }
            
            if(!enter)
                break;
            
            enter = false;
            
        }
        
        return maxScore;
    }
}