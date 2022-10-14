class Solution {
    
    public boolean needToReverse(int n1, int s1, int target){
        return (n1 > target && s1 > 0) || (n1 < target && s1 < 0);
    }
    
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1, 0});
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair(0, 1));
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == target){
                return curr[2];
            }

            
            int count = curr[2];
            int n1 = curr[0] + curr[1];
            int s1 = curr[1] * 2;
            
            int n2 = curr[0];
            int s2 = (curr[1] > 0 ? -1: 1);
            
            if(!visited.contains(new Pair(n1, s1))){
                q.add(new int[]{n1, s1, count + 1});
                visited.add(new Pair(n1, s1));
            }
            
            if(!visited.contains(new Pair(n2, s2)) && needToReverse(n1, s1, target)){
                q.add(new int[]{n2, s2, count+1});
                visited.add(new Pair(n2, s2));
            }
        }
        
        return -1;
    }
}