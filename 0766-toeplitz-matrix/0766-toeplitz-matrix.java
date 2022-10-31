class Solution {
    int r,c;

	public boolean check(int[][] matrix, int i, int j){
		int val = matrix[i][j];
		while(i< r && j<c){
			if(matrix[i][j] != val)
				return false;
			i++; j++;
		}
        
        return true;
	}

	public boolean checkFirstRow(int[][] matrix){
        for(int j=0; j<c; j++){
            if(!check(matrix, 0, j))
                return false;
        }

        return true;
    }

    public boolean checkFirstCol(int[][] matrix){
        for(int i=0; i<r; i++){
            if(!check(matrix, i, 0))
                return false;
        }

        return true;
	}

    public boolean isToeplitzMatrix(int[][] matrix) {
     	r = matrix.length;
		c = matrix[0].length;

		return checkFirstRow(matrix) && checkFirstCol(matrix);
    }
}

