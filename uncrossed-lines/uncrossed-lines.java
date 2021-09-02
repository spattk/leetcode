class Solution {
    
    Map<String,Integer> map;
    public int solve(int[] a, int[] b, int n1, int n2){
        if (n1 <0 || n2<0){
            return 0;
        }
        
        String key = "" + n1 + "*" + n2;
        if(map.get(key)!=null){
            return map.get(key);
        }
        
        if(a[n1] == b[n2]){
            int result =  1 + solve(a, b, n1-1, n2-1);
            map.put(key, result);
            return result;
        }
        
        int result = Math.max(solve(a,b,n1-1, n2), solve(a,b,n1,n2-1));
        map.put(key, result);
        return result;
        
    }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        return solve(nums1, nums2, nums1.length-1, nums2.length-1);
    }
}