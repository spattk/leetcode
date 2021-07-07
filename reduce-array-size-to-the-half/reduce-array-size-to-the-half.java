import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

class Solution {
    public int minSetSize(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        Map<Integer, Integer> sorted1 = map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));
        
        int n = arr.length;
        int curr = n;
        int set = 0;
        
        for(Map.Entry<Integer, Integer> entry: sorted1.entrySet()){
            // System.out.println(entry.getKey());
            if (curr <= n/2){
                return set;
            }
            curr -= entry.getValue();
            set++;
        }
        
        return set;
    }
}