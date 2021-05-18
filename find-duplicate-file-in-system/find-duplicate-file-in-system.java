class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String path: paths){
            String[] arr = path.split(" ");
            String dir = arr[0];
            
            for(int i=1; i<arr.length; i++){
                int idx = arr[i].indexOf("(");
                String file = arr[i].substring(0, idx);
                String content = arr[i].substring(idx+1, arr[i].length()-1);
                List<String> filepaths = map.getOrDefault(content, new ArrayList<>());
                filepaths.add(dir + "/" + file);
                map.put(content, filepaths);
            }
        }
        
        map.entrySet().removeIf(entry -> entry.getValue().size() < 2);
        return new ArrayList<>(map.values());
    }
}