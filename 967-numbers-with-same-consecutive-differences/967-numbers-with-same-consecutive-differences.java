class Solution {
    
    Set<Integer> result = new HashSet<>();

    public void solver(int n, int idx, List<Integer> currNumbers, int k, int lastNum){
        
        if(currNumbers.size() == n){
            int completeNum = 0;
            for(int num: currNumbers){
                completeNum = completeNum * 10 + num;
            }
            result.add(completeNum);
            return;
        }
        
        if(lastNum + k <= 9) {
            currNumbers.add(lastNum+k);
            solver(n, idx+1, currNumbers, k, lastNum+k);
            currNumbers.remove(currNumbers.size()-1);
        }
        
        if(lastNum - k >=0 ) {
            currNumbers.add(lastNum-k);
            solver(n, idx+1, currNumbers, k, lastNum-k);
            currNumbers.remove(currNumbers.size()-1);
        }
    }
    
    public void setFirstPos(List<Integer> firstPos, int k){
        for(int i=1; i<=9; i++){
            if(i + k <= 9){
                firstPos.add(i);
            }
            if(i-k >= 0){
                firstPos.add(i);
            }
        }
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        
        List<Integer> firstPos = new ArrayList<>();
        setFirstPos(firstPos, k);
        
        for(int first: firstPos){
            curr.add(first);
            solver(n, 1, curr, k, first);
            curr.remove(curr.size()-1);
        }
        
        int[] ans = new int[result.size()];
        int z = 0;
        for(int num: result){
            ans[z++] = num;
        }
        return ans;
    }
}