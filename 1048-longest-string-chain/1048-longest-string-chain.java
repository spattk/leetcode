class Solution {
    
    public boolean isPred(String w1, String w2){
        if(w1.length() != w2.length() - 1)
            return false;
        
        int diff = 0;
        int i, j;
        int n = w1.length();
        for(i=0, j=0;i<n;){
            if(w1.charAt(i) == w2.charAt(j)){
                i++;
                j++;
            } else {
                if(diff == 1)
                    return false;
                j++;
                diff++;
            }
        }
        
        return true;
    }
    
    public int longestStrChain(String[] words) {
        int n = words.length;
        int result = 1;
        Arrays.sort(words, (w1, w2)->w1.length()-w2.length());
        // System.out.println(Arrays.toString(words));
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isPred(words[i], words[j])){
                    count[j] = Math.max(count[j], count[i] + 1);
                    result = Math.max(result, count[j]);
                }
            }
        }
        
        // System.out.println(Arrays.toString(count));
        
        return result;
    }
}