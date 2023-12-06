class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    Set<String> resultSet = new HashSet<>();
    List<Integer> tempList = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    
    private String getArrStr(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for(int num: list){
            sb.append(num);
            sb.append(",");
        }
        return sb.toString();
        
    }
    
    public void permuteUniqueSolver(int [] nums){
        if (tempList.size() == nums.length){
            String arr = getArrStr(tempList);
            if(!resultSet.contains(arr)){
                resultSet.add(arr);
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                tempList.add(nums[i]);
                permuteUniqueSolver(nums);
                tempList.remove(tempList.size() -1 );
                visited.remove(i);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteUniqueSolver(nums);
        return result;
    }
}