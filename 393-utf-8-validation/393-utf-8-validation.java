class Solution {
    public boolean validUtf8(int[] data) {
        int rem = 0;
        for(int ele: data){
            if(rem == 0) {
                if((ele >> 5) == 0b110){
                    rem = 1;
                } else if ((ele >> 4) == 0b1110) {
                    rem = 2;
                } else if ((ele >> 3) == 0b11110) {
                    rem = 3;
                } else if ((ele >> 7) != 0) {
                    return false;
                }
            } else {
                if(rem != 0){
                    if((ele >> 6) != 0b10) {
                        return false;
                    }
                    rem--;
                }                
            }
        }
        
        return rem == 0;
    }
}