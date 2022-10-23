class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        //attack -> list(defense)
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxA = 0, minA = (int) 1e5 + 1;
        for(int[] ele: properties) {
            map.putIfAbsent(ele[0], new ArrayList<>());
            map.get(ele[0]).add(ele[1]);
            maxA = Math.max(maxA, ele[0]);
            minA = Math.min(minA, ele[0]);
        }
        
        int maxD = -1;
        int count = 0;
        for(int i=maxA; i>=minA; i--) {
            if(map.get(i) == null)
                continue;
            
            for(int def: map.get(i)){
                if(def < maxD)
                    count++;
            }
            
            for(int def: map.get(i)){
                maxD = Math.max(maxD, def);
            }
            
        }
        
        return count;
    }
}