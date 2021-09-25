public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int count = 0;
        while(count < 32) {
            count ++;
            result = result << 1;
            if ((n & 1) == 1){
                result += 1;
            }
            // System.out.println(Integer.toBinaryString(result));
            n = n >> 1;
        }
        System.out.println(count);
 
        return result;
    }
}