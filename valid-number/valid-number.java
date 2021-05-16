class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        int ne=0, ndigits=0,nplusminus = 0, ndot=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                ndigits++;
            }
            else if (ch == '+' || ch == '-'){
                if (nplusminus == 2){
                    return false;
                }
                if ((i >0 && Character.toLowerCase(s.charAt(i-1)) != 'e') || (i == n-1)){
                    return false;
                }
                nplusminus++;
            }
            else if (Character.toLowerCase(ch) == 'e'){
                if (ndigits == 0 || i == n-1 || ne > 0){
                    return false;
                }
                else if (!(Character.isDigit(s.charAt(i+1)) || s.charAt(i+1) == '+' || s.charAt(i+1) == '-')){
                    return false;
                }
                
                ne ++;
            }
            else if (ch == '.'){
                if (ne >0 || ndot == 1){
                    return false;
                }
                else if (i==n-1 && ndigits == 0){
                    return false;
                }
                ndot++;
            }
            else {
                return false;
            }
        }
        return true;
    }
}