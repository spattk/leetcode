class Solution {
    public int minPartitions(String n) {
        char temp = '0';
        for(char ch: n.toCharArray()){
            if (ch > temp){
                temp = ch;
            }
        }
        return Integer.parseInt("" + temp);
    }
}