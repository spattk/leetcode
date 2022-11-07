class Solution {
    public int maximum69Number (int num) {
        String str = "" + num;
        char[] chs = str.toCharArray();
        
        for(int i=0; i<chs.length; i++){
            if(chs[i] == '6'){
                chs[i] = '9';
                break;
            }
        }
        
        return Integer.parseInt(new String(chs));
    }
}