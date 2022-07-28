class Solution {
    public int strStr(String haystack, String needle) {
        //sliding window + number
        
        int n = needle.length();
        
        if(needle.length() > haystack.length())
            return -1;
        
        int nSum = 0;
        for(int i=0; i<n; i++){
            nSum += (needle.charAt(i) - 'a') * 3;
        }
        
        
        
        int hSum = 0;
        for(int i=0; i<n; i++){
            hSum += (haystack.charAt(i) - 'a') * 3;
        }
        
        if(nSum == hSum && needle.equals(haystack.substring(0,n)))
            return 0;
        
        System.out.println(nSum + ":" + hSum );
        
        for(int i=n; i< haystack.length(); i++){
            hSum = (hSum/3 - (haystack.charAt(i-n) - 'a') + (haystack.charAt(i) - 'a')) * 3;
            if(hSum == nSum){
                if(needle.equals(haystack.substring(i-n+1, i-n+1+n)))
                    return i-n+1;
            }
        }
        
        return -1;
    }
}