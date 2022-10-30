class Solution {
    
    public int gcd(int a, int b){
        if (a == 0)
            return b;
 
        return gcd(b % a, a);
    }
    
    public int[] getSlope(int[] p1, int[] p2){
        if(p1[0] == p2[0])
            return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        if(p1[1] == p2[1])
            return new int[]{0, 0};
        
        int delX = p1[0] - p2[0];
        int delY = p1[1] - p2[1];
        int gcd = gcd(delX, delY);
        return new int[] {delY/gcd, delX/gcd};
    }
    
    public boolean isSame(int[] p, int []q){
        return p[0] == q[0] && p[1] == q[1];
    }
    
    public String getKey(int[] p){
        return p[0] + "#" + p[1];
    }
    
    public int maxPoints(int[][] points) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        int n = points.length, max = 1;
        
        
        if(n == 1 || n == 2)
            return n;
        
        for(int i=0;i<n && !set.contains(points[i][0] + "-" + points[i][1]);i++){
            map.clear();
            int same = 0, localMax = 1;
            for(int j=0;j<n;j++){
                
                if(i == j)
                    continue;
                if(isSame(points[i], points[j]))
                    same++;
                // String slope = getSlope(points[i], points[j]);
                int[] slope = getSlope(points[i], points[j]);
                map.put(getKey(slope), map.getOrDefault(getKey(slope), 1) + 1);
                localMax = Math.max(localMax, map.get(getKey(slope)));
            }
            
            max = Math.max(max, localMax + same);
            set.add(points[i][0] + "-" + points[i][1]);
        }
        
        
        return max;
    }
}