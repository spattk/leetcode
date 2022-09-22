class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> count = new HashMap<>();
        for(String cpdomain: cpdomains) {
            String [] parts = cpdomain.split(" ");
            String [] domains = parts[1].split("\\.");
            
            String curr = "";
            int n = domains.length;
            for(int i=n-1; i>=0; i--){
                curr = i == n-1 ? domains[i] : domains[i] + "." + curr ;
                Integer currCount = count.getOrDefault(curr, 0) + Integer.parseInt(parts[0]);
                count.put(curr, currCount);
            }
        }
        
        List<String> result = new ArrayList<>();
        for(String key: count.keySet()){
            String ans = count.get(key) + " " + key;
            result.add(ans);
        }
        
        return result;
    }
}