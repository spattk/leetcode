class Solution {
    
    public boolean isATriplet(char first, char second, char third){
        return first == 'A' && second == 'A' && third == 'A';
    }
    
    public boolean isBTriplet(char first, char second, char third){
        return first == 'B' && second == 'B' && third == 'B';
    }
    
    public boolean winnerOfGame(String colors) {
        int aTriplets = 0, bTriplets = 0;
        char first = '0', second = '0', third = '0';
        if(colors.length() >=3  ) {
            first = colors.charAt(0);
            second = colors.charAt(1);
            third = colors.charAt(2);
        }
        
        if(isATriplet(first, second, third)){
            aTriplets++;
        } else if (isBTriplet(first, second, third)) {
            bTriplets++;
        }
        
        for(int i=1; i<=colors.length() - 3; i++){
            first = second;
            second = third;
            third = colors.charAt(i+2);
            
            if(isATriplet(first, second, third)){
                aTriplets++;
            } else if (isBTriplet(first, second, third)) {
                bTriplets++;
            }
        }
        
        
        if(aTriplets > bTriplets)
            return true;
        return false;
    }
}