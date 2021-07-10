class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num: nums){
            if (set.isEmpty()){
                set.add(num);
            } else {
                Integer key = set.ceiling(num);
                if (key != null) {
                    set.remove(key);
                } 
                set.add(num);
            }
        }
        return set.size();
    }
}