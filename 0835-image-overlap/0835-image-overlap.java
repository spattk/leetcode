class Solution {
    /**
     *  Shift the matrix M in up-left and up-right directions 
     *    and count the ones in the overlapping zone.
     */
    protected int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
        int leftShiftCount = 0, rightShiftCount = 0;
        // count the cells of ones in the overlapping zone.
        for (int mRow = yShift, rRow = 0; mRow < M.length; ++mRow, ++rRow) {
            for (int mCol = xShift, rCol =0; mCol < M.length; ++mCol, ++rCol) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
                    leftShiftCount += 1;
                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol])
                    rightShiftCount += 1;
            }
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int maxOverlaps = 0;

        for (int yShift = 0; yShift < A.length; ++yShift)
            for (int xShift = 0; xShift < A.length; ++xShift) {
                // move the matrix A to the up-right and up-left directions.
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
                // move the matrix B to the up-right and up-left directions, which is equivalent to moving A to the down-right and down-left directions 
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
            }

        return maxOverlaps;
    }
}