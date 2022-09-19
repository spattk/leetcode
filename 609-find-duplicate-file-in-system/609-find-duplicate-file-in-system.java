class Solution {
    
    
    public void process(Map<String, List<String>> contentFileMap, String[] files){
        String basePath = files[0];
        for(int i=1; i<files.length; i++){
            int idx = files[i].indexOf("(");
            String content = files[i].substring(idx+1, files[i].length());
            List<String> list = contentFileMap.getOrDefault(content, new ArrayList<>());
            list.add(basePath + "/" + files[i].substring(0, idx));
            contentFileMap.put(content, list);
        }
    }
    
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentFileMap = new HashMap<>();
        for(String path: paths){
            String[] pArr = path.split(" ");
            process(contentFileMap, pArr);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(String key: contentFileMap.keySet()){
            List<String> curr = contentFileMap.get(key);
            if(curr.size() > 1)
                result.add(curr);
        }
        
        return result;
    }
}