class Solution {
    public boolean winnerOfGame(String colors) {
        int aTriplets = 0, bTriplets = 0;
        for(int i=0; i<=colors.length() - 3; i++){
            String str = colors.substring(i, i+3);
            if(str.equals("AAA")){
                aTriplets++;
            } else if (str.equals("BBB")) {
                bTriplets++;
            }
        }
        
        // System.out.println(aTriplets + " " + bTriplets);
        if(aTriplets > bTriplets)
            return true;
        return false;
    }
}