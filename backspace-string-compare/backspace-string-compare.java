class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        
        char ch1, ch2, ch;
        int h1=0, h2=0;
        
        while(i>=0 && j >=0){
            ch1 = s.charAt(i);
            ch2 = t.charAt(j);
            
            if(ch1 != '#' && h1 >0){
                h1--;
                i--;
                continue;
            }
            
            if(ch2 != '#' && h2>0){
                h2--;
                j--;
                continue;
            }
            
            
            if(ch1 != '#' && ch2 != '#'){
                if(ch1 != ch2){
                    return false;
                }
                i--; j--;
            } else if(ch1 == '#' && ch2 == '#') {
                h1++;
                h2++;
                i--; j--;
            } else if(ch1 == '#' && ch2 != '#') {
                h1++;
                i--;
            } else if(ch1 != '#' && ch2 == '#') {
                h2++;
                j--;
            }
        }
        
        while(i>=0){
            ch = s.charAt(i);
            if(ch != '#' && h1 > 0) {
                h1--;
            } else if (ch != '#'){
                return false;
            } else if (ch == '#'){
                h1++;
            }
            i--;
        }
        
        while(j>=0){
            ch = t.charAt(j);
            if(ch != '#'){
                if(h2>0){
                    h2--;
                }
                else{
                    return false;
                }
            } else {
                h2++;
            }
            j--;
        }
        
        return true;
    }
}