class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        
        for(int k=1;k<=n;k++){
            int temp = (int)Math.pow(2, k-1);
            int size = result.size();
            List<Integer> newList = new ArrayList<>();
            for(int j=size-1;j>=0;j--){
                int toAdd = temp + result.get(j);
                newList.add(toAdd);
            }
            result.addAll(newList);
        }
        
        return result;
    }
}