class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int count = 1;
        
        boolean[] higher = new boolean[n];
        higher[n-1] = true;
        boolean[] lower = new boolean[n];
        lower[n-1] = true;
        //ele, index
        TreeMap<Integer , Integer> map = new TreeMap<>();
        map.put(arr[n-1], n-1);
        
        for(int i=n-2; i>=0; i--){
            Map.Entry<Integer, Integer> high = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> low = map.floorEntry(arr[i]);
            
            if(high != null){
                higher[i] = lower[high.getValue()];
            }
            
            if(low != null){
                lower[i] = higher[low.getValue()];
            }
            
            if(higher[i])
                count++;
            
            map.put(arr[i], i);
        }
        
        return count;
    }
}