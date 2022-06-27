class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A1 = nums1;
        int[] A2 = nums2;
        
        if(nums2.length < nums1.length){
            A1 = nums2;
            A2 = nums1;
        }
        
        int n1 = A1.length;
        int n2 = A2.length;
        
        int lo = 0, hi = n1;
        int cut1, cut2, L1, L2, R1, R2;
        while(lo <= hi){
            cut1 = (lo + hi)/2;
            cut2 = (n1 + n2 + 1)/2 - cut1;
            
            L1 = (cut1 == 0) ? Integer.MIN_VALUE : A1[cut1-1];
            R1 = (cut1 == n1) ? Integer.MAX_VALUE : A1[cut1];
            
            L2 = (cut2 == 0) ? Integer.MIN_VALUE : A2[cut2 - 1];
            R2 = (cut2 == n2) ? Integer.MAX_VALUE : A2[cut2];
            
            if(L1 > R2){
                hi = cut1 - 1;
            } else if (L2 > R1) {
                lo = cut1 + 1;
            } else {
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2))/2.0;
                } else {
                    return 1.0 * Math.max(L2, L1);
                }
            }
        }
        
        return 0;
    }
}