class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch != '-')
                sb.append(ch);
        }
        
        int n = sb.length();
        
        int groups = n/k;
        int first = n - groups*k;
        String result = "";
        boolean set = false;
        System.out.println(sb.toString());
        int count = 0;
        for(int i=0;i<n;i++){
            
            count ++;
            result += Character.toUpperCase(sb.charAt(i));
            
            if(set == false && count == first){
                set = true;
                result += "-";
                count = 0;
                
            } else if(count == k){
                result += "-";
                count = 0;
            }
        }
        
        int l = result.length();
        if(l > 0 && result.charAt(l-1) == '-'){
            return result.substring(0, l-1);
        }
        return result;
    }
}