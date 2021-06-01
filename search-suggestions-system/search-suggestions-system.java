class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0;i<products.length;i++){
            map.put(products[i],i);
        }
        
        List<List<String>> ans = new ArrayList<>();
        String key = "";
        List<String> temp = new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            key += searchWord.charAt(i);
            String ceilKeyStr = map.ceilingKey(key);
            String floorKeyStr = map.floorKey(key + "{");
            temp = new ArrayList<>();
            if (ceilKeyStr == null){
                ans.add(temp);
                continue;
            }
            
            int ceilKey = map.get(map.ceilingKey(key));
            int floorKey = map.get(map.floorKey(key + "{"));
            int count = 0;
            for(int j=ceilKey;(j<floorKey + 1) && count < 3; j++){
                temp.add(products[j]);
                count ++;
            }
            ans.add(temp);
        }
        return ans;
    }
}