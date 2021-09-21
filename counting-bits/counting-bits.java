class Solution {
    
    public int countOnes(int n){
        int count = 0;
        while(n != 0){
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }
    
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i=0;i<=n;i++){
            res[i] = countOnes(i);
        }
        return res;
    }
}