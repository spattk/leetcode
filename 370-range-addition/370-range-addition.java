class Solution {
    public int[] getModifiedArray(int n, int[][] updates) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] update: updates){
            map.put(update[0], map.getOrDefault(update[0], 0)+update[2]);
            map.put(update[1] + 1, map.getOrDefault(update[1] + 1, 0) -1 * update[2]);;
        }
        
        int[] result = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            if(map.get(i) != null){
                sum += map.get(i);
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}