class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for(char ch: s.toCharArray())
            count[ch-'a']++;
        
        Arrays.sort(count);
        
        int n = 26;
        int curr = count[n-1];
        int result = 0;
        for(int i=n-2;i>=0;i--){
            if(count[i]==0)
                continue;
            
            if(curr == 0){
                int diff = count[i];
                count[i] -= diff;
                result += diff;
            }
            
            else if(count[i]>=curr){
                int diff = count[i] - (curr - 1);
                count[i] -= diff;
                result += diff;
            }
            
            curr = count[i];
        }
        
        return result;
    }
}