class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        
        int top = 0, bottom = r-1, left = 0, right = c-1;
        while(left<=right && top <= bottom){
            System.out.println("top " + top + " bottom " + bottom + " left " + left + " right " + right);
            //top
            System.out.println(" top ");
            if(top <= bottom){
                for(int i=left; i<=right;i++){
                    System.out.println(matrix[top][i] + " ");
                    result.add(matrix[top][i]);
                }
                ++top;
            }
            
            
            
            //right
            System.out.println(" right ");
            if(left <= right){
                for(int i=top; i<=bottom; i++){
                    System.out.println(matrix[i][right] + " ");
                    result.add(matrix[i][right]);
                }
                --right;
            }
            
            
            System.out.println(" bottom ");
            //bottom
            if(top <= bottom){
                for(int i=right; i>=left; i--){
                    System.out.println(matrix[bottom][i] + " ");
                    result.add(matrix[bottom][i]);
                }
                --bottom;
            }
            
            System.out.println(" left ");
            //left
            if(left <= right){
                for(int i=bottom; i >= top; i--){
                    System.out.println(matrix[i][left] + " ");
                    result.add(matrix[i][left]);
                }
                ++left;
            }
            
        }
        
        return result;
    }
}