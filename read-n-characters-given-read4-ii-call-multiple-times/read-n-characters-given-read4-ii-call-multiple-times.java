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
    
    char[] buf4 = new char[4];
    int readPos = 0;
    int writePos = 0;
    public int read(char[] buf, int n) {
        for(int i=0;i<n;i++){
            if(readPos == writePos){
                writePos = read4(buf4);
                readPos = 0;
                if(writePos == 0)
                    return i;
            }
            
            buf[i] = buf4[readPos++];
        }
        return n;
    }
}