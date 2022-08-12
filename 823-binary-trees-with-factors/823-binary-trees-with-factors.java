class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        long mod = (long)1e9 + 7;
        Map<Integer, Long> count = new HashMap<>();
        
        for(int ele: arr)
            count.put(ele, 1L);
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i ;j++){
                long c = 0;
                if(arr[i]%arr[j] == 0){
                    int div = arr[i]/arr[j];
                    if(count.get(div) == null)
                        continue;
                    
                    c += count.get(arr[j]) * count.get(div);
                }
                
                count.put(arr[i], (count.get(arr[i]) + c)%mod);
            }
        }
        
        long sum = 0L;
        for(int key: count.keySet()){
            sum += count.get(key);
            sum %= mod;
        }
        
        return (int)(sum%mod);
    }
}