class Solution {
    
    public String getNumber(String abbr, int i){
        int start = i;
        while(i < abbr.length() && !Character.isLetter(abbr.charAt(i))){
            i++;
        }
        return abbr.substring(start,i);
    }
    
    public boolean validWordAbbreviation(String word, String abbr) {
        //both should finish together.
        
        int i=0, j=0;
        int n1= word.length(), n2 = abbr.length();
        while(j<n2){
            char ch = abbr.charAt(j);
            if(Character.isLetter(ch)){
                if(i >= n1)
                    return false;
                if(ch != word.charAt(i))
                    return false;
                i++;
                j++;
            } else {
                //find the max number that is forming.
                if(ch == '0'){
                    return false;
                }
                
                String num = getNumber(abbr, j);
                j+=num.length();
                i+=Integer.parseInt(num);
            }
        }
        
        return i == n1;
    }
}