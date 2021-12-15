class Solution {
    
    class Node implements Comparable<Node> {
        int val;
        int idx;
        
        Node(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        
        public String toString(){
            return this.val + " " + this.idx;
        }
        
        @Override
        public int compareTo(Node n) {
            //let's sort the employee based on an id in ascending order
            //returns a negative integer, zero, or a positive integer as this employee id
            //is less than, equal to, or greater than the specified object.
            if(this.val != n.val){
                return n.val - this.val;
            }
            return 0;
        }
    }
    
    HashMap<String, Boolean> map;
    public int oddEvenJumps(int[] arr) {
        map = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        
        int count = 0;
        int n = arr.length;
        treeMap.put(arr[n-1], n-1);
        
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        
        odd[n-1] = true;
        even[n-1] = true;
        
        for(int i=n-2;i>=0;i--){
            Integer temp;
            temp = treeMap.ceilingKey(arr[i]);
            if(temp != null){
                odd[i] = even[treeMap.get(temp)];
            }
            
            temp = treeMap.floorKey(arr[i]);
            
            if(temp != null){
                even[i] = odd[treeMap.get(temp)];
            }
            
            treeMap.put(arr[i], i);
        }
        
        for(int i=0;i<n;i++)
            if(odd[i])
                count++;
        
        return count;
        
    }
}