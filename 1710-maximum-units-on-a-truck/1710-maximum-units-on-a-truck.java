class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a1, a2)->Integer.compare(a2[1],a1[1]));
        
        int result = 0;
        for(int i=0; i<boxTypes.length; i++){
            
            if(truckSize == 0)
                break;
            
            int size= Math.min(truckSize, boxTypes[i][0]);
            result += size * boxTypes[i][1];
            truckSize -= size;
        }
        return result;
    }
}