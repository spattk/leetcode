class Solution {
    
    public void fillDiagMap(int[][]mat, Map<Integer, List<Integer>> diagMap){
        int r = mat.length;
        int c = mat[0].length;
        
        for(int row=0; row<r; row++){
            for(int col=0; col<c; col++){
                int diff = col - row;
                List<Integer> curr = diagMap.getOrDefault(diff, new ArrayList<>());
                curr.add(mat[row][col]);
                diagMap.put(diff, curr);
            }
        }
    }
    
    public void sortMap(Map<Integer, List<Integer>> diagMap){
        for(int key: diagMap.keySet()){
            List<Integer> curr = diagMap.get(key);
            Collections.sort(curr);
            diagMap.put(key, curr);
        }
    }
    
    public int[][] fillMatrixWithSortedValues(int[][] mat, Map<Integer, List<Integer>> diagMap, Map<Integer, Integer> indexMap) {
        int r = mat.length;
        int c = mat[0].length;
        
        for(int row=0; row<r; row++){
            for(int col=0; col<c; col++){
                int diff = col - row;
                mat[row][col] = diagMap.get(diff).get(indexMap.getOrDefault(diff, 0));
                int currIdx = indexMap.getOrDefault(diff, 0);
                currIdx++;
                indexMap.put(diff, currIdx);
            }
        }
        
        return mat;
    }
    
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, List<Integer>> diagMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        fillDiagMap(mat, diagMap);
        sortMap(diagMap);
        
        return fillMatrixWithSortedValues(mat, diagMap, indexMap);
    }
}