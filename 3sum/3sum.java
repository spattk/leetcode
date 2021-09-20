class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3){
            return new ArrayList<>();
        }
        
        int k = 1;
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        while(k < n-1){
            int i =0;
            int j = n-1;
            while(i < j){
                int curr = nums[i] + nums[j] + nums[k];
                if(curr == 0 ){
                    
                    if (i!=j && j!=k && i!=k ){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        if(!set.contains(temp)){
                            result.add(temp);
                            set.add(temp);
                        }
                        
                        
                    }
                    i++;
                    j--;
                }
                else if (curr < 0 && i<k-1) {
                    i++;
                }
                else if (curr < 0) {
                    break;
                }
                else if (curr > 0 && j>k+1){
                    j--;
                }
                else if(curr > 0){
                    break;
                }
            }
            k++;
        }
        
        return result;
    }
}