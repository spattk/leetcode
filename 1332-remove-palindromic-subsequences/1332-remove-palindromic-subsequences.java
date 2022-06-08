class Solution {
    
    public boolean isPalindrome(String s){
        int i=0; int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public int removePalindromeSub(String s) {
        if(isPalindrome(s)){
            return 1;
        }
        
        boolean isA = false;
        boolean isB = false;
        
        for(char ch: s.toCharArray()){
            if(ch == 'a'){
                isA = true;
            }
            
            if(ch == 'b'){
                isB = true;
            }
        }
        
        if(isA && isB)
            return 2;
        
        return 1;
    }
}