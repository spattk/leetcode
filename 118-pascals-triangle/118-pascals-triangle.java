class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            List<Integer> temp = new ArrayList<>();
            if(i == 1){
                temp.add(1);
                result.add(temp);
            } else if(i == 2) {
                temp.add(1);
                temp.add(1);
                result.add(temp);
            } else {
                temp.add(1);
                for(int k=0;k<i-2;k++){
                    temp.add(result.get(result.size()-1).get(k) + result.get(result.size()-1).get(k+1));
                }
                temp.add(1);
                result.add(temp);
            }
        }
        
        return result;
    }
}
