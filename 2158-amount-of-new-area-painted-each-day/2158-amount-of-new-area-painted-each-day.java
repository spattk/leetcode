class Solution {
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, Integer> range = new TreeMap<>();
        int[] result = new int[paint.length];
        int n = paint.length;
        for(int i=0; i<n; i++){
            int [] p = paint[i];
            int start = p[0];
            int end = p[1];
            int toPaint = end - start;

            Integer floorKey = range.floorKey(p[0]);
            if(floorKey != null){
                if(range.get(floorKey) >= end){
                    continue;
                }
                
                if(range.get(floorKey) >= start){
                    toPaint -= range.get(floorKey) - start;
                    range.remove(floorKey);
                    start = floorKey;
                }
            }
            
            Integer ceilingKey = range.ceilingKey(p[0]);
            while(ceilingKey != null && ceilingKey <= end){
                toPaint -= Math.min(end, range.get(ceilingKey)) - ceilingKey;
                end = Math.max(end, range.get(ceilingKey));
                range.remove(ceilingKey);
                ceilingKey = range.ceilingKey(p[0]);
            }
            
            result[i] = toPaint;
            range.put(start, end);
        }
        
        return result;
    }
    
}