class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<String> pairs = new HashSet<>();
        for(int num: nums){
            if(set.contains(num-k)){
                pairs.add("" + (num-k) + "," + num);
            }
            if(set.contains(num+k)){
                pairs.add("" + num + "," + (num+k));
            }
            
            set.add(num);
        }
        
        return pairs.size();
    }
}