class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long mod = (long)1e9 + 7;
        long result = 0;
        long[] pow = new long[n];
        pow[0] = 1;
        for(int i=1; i<n; i++){
            pow[i] = (pow[i-1] * 2)%mod;
        }
        for(int i=0; i<n; i++){
            result = (result + nums[i] * (pow[i]-pow[n-i-1])) % mod;
        }
        
        return (int) ((result + mod )%mod);
    }
}