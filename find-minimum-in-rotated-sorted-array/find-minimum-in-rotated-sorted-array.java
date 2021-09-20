class Solution {
    public int findMin(int[] num) {
        int low = 0, high = num.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < num[high])
                // the mininum is in the left part
                high = mid;
            else if (num[mid] > num[high])
                // the mininum is in the right part
                low = mid + 1;
        }

        return num[low];
    }
}