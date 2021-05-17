class Solution {
    public boolean isChain(String a, String b){
        
       if (b.length() - a.length() != 1)
           return false;
        
        
        char[] temp1 = a.toCharArray();
        // Arrays.sort(temp1);
        char[] temp2 = b.toCharArray();
        // Arrays.sort(temp2);
        
        int i = 0, j=0;
        int count = 0;
        while (i<a.length() && j<b.length()){
            if(temp2[j] == temp1[i]){
                i++;j++;
                continue;
            }else{
                if (count == 1){
                    
                    return false;
                }
                j++;
                count++;
            }
        }
        return true;
        
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)-> Integer.compare(a.length(), b.length()));
        int[] result = new int[words.length];
        Arrays.fill(result,1);
        int n = words.length;
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                if (isChain(words[i], words[j])){
                    // System.out.println(i + " " + j);
                    result[j] = Math.max(result[j], result[i] + 1);
                    max = Math.max(max, result[j]);
                }
            }
        }
        // for(int s: result){
        //     System.out.println(s);
        // }
        return max;
    }
}