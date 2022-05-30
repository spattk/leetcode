import java.util.*;

class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        
        int temp1 = dividend; 
        int temp2 = divisor;
        int result = 0, count = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        while(dividend - divisor >= 0){
            count = 0;
            while((dividend - (divisor <<  1 << count)) >= 0){
                count++;
            }
            
            result += 1 << count;
            dividend -= divisor << count;
        }
        
        return (temp1 > 0) == (temp2 > 0) ? result : -result;
        
    }
}