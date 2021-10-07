class Solution {
    
    class Graph {
        Map<Integer, Integer> rank;
        Map<Integer, Integer> parent;
        
        Graph(int[] nums){
            rank = new HashMap<>();
            parent = new HashMap<>();
            
            for(int n: nums){
                rank.put(n, 0);
                parent.put(n, n);
            }
        }
        
        public int findParent(int p){
            System.out.println("---^^p : " + p + " : " + parent.get(p));
            if(parent.get(p) != p){
                int temp = findParent(parent.get(p));
                parent.put(p, temp);
            }
            return parent.get(p);
        }
        
        public void union(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);
            
            if(px != py){
                int rx = rank.get(px);
                int ry = rank.get(py);
                
                if(rx < ry){
                    parent.put(px,py);
                } else if (rx > ry) {
                    parent.put(py, px);
                } else {
                    parent.put(py, px);
                    rank.put(px, rank.getOrDefault(px,0)+1);
                }
            }
            
        }
    }
    
    public int longestConsecutive(int[] nums) {
        Graph g = new Graph(nums);
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(nums[i]-1)){
                g.union(nums[i], nums[i]-1);
            }
            
            if(set.contains(nums[i]+1)){
                g.union(nums[i], nums[i]+1);
            }
            
            set.add(nums[i]);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> currSet = new HashSet<>();
        for(int num: nums){
            currSet.add(num);
        }
        int result = 0;
        for(int no: currSet){
            System.out.println("no " + no);
            int parent = g.findParent(no);
            System.out.println("parent " + parent);
            int temp = map.getOrDefault(parent, 0) + 1;
            System.out.println("temp " + temp);
            map.put(parent, temp);
            result = Math.max(result, temp);
        }
        
        return result;
    }
}