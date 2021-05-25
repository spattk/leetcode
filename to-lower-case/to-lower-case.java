class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int ch = (int) s.charAt(i);
            if (ch>=65 && ch <=90){
                ch = ch + 32;
            }
            sb.append((char)ch);
        }
        return sb.toString();
    }
}