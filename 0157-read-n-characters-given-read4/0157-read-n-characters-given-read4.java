/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int curr = 0;
        while(curr < n){
            int ret = read4(temp);
            for(int i=0; i<ret && curr<n; i++){
                buf[curr] = temp[i];
                curr++;
            }
            if(ret < 4){
                break;
            }
        }
        
        return curr;
    }
}