class Solution {
    
    public void createFromSet(Set<String> set, List<List<Integer>> result){
        for(String str: set){
            List<Integer> ans = new ArrayList<>();
            String[] arr = str.split(",");
            for(String ele : arr){
                if(!ele.equals(""))
                    ans.add(Integer.parseInt(ele));
            }
            result.add(ans);
        }
    }
    
    public void generateSet(Set<String> set, int[] nums, int idx, List<Integer> path){
        if(idx == nums.length){
            String temp = "";
            for(int i=0;i<path.size();i++){
                temp += path.get(i);
                if(i != path.size() - 1)
                    temp += ",";
            }
            set.add(temp);
            return;
        }
        
        path.add(nums[idx]);
        generateSet(set, nums, idx + 1, path);
        path.remove(path.size()-1);
        generateSet(set, nums, idx + 1, path);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        
        List<Integer> path = new ArrayList<>();
        generateSet(set, nums, 0, path);
        
        for(int k=1;k<=n;k++){
            for(int i=0;i+k-1<n;i++){
                String str = "";
                for(int j=i; j<i+k; j++){
                    str += nums[j] ;
                    if(j != i + k -1)
                        str += ",";
                }
                set.add(str);
            }
        }
        // System.out.println(set);
        List<List<Integer>> result = new ArrayList<>();
        // result.add(new ArrayList<>());
        createFromSet(set, result);
        return result;
    }
}