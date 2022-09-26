class Solution {
    
    public int getSpace(List<String> curr, int maxWidth){
        int total = 0;
        for(String str: curr) {
            total += str.length();
        }
        
        return maxWidth - total;
    }
    
    public void processLines(List<List<String>> lines, int maxWidth, List<String> res) {
        int n = lines.size();
        for(int i=0; i<n; i++){
            List<String> curr = lines.get(i);
            StringBuilder sb = new StringBuilder();
            int space = getSpace(curr, maxWidth);
            
            if(curr.size() ==1) {
                sb.append(curr.get(0));
                while(space -- > 0){
                    sb.append(" ");
                }
            } 
            
            else if(i == n-1) {
                int len = 0;
                for(int z =0; z<curr.size(); z++) {
                    if(z != curr.size() -1 ){
                        sb.append(curr.get(z) + " ");
                        len += curr.get(z).length() + 1;
                    } else {
                        sb.append(curr.get(z));
                        len += curr.get(z).length();
                    }
                }
                
                while(len < maxWidth){
                    sb.append(" ");
                    len++;
                }
                
            } 
            
            else {
                int cn = curr.size() - 1;
                int per = space/cn;
                int extra = space - per*cn;
                
                
                for(int z=0; z<curr.size(); z++){
                    if(z != curr.size() -1 ){
                        sb.append(curr.get(z));
                        for(int y=0; y<per; y++){
                            sb.append(" ");
                        }
                        
                        if(extra != 0){
                            sb.append(" ");
                            extra--;
                        }
                        
                    } else {
                        sb.append(curr.get(z));
                    }
                }
            }
            
            res.add(sb.toString());
        }
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        int i=0, n = words.length;
        int rem = maxWidth;
        List<String> curr = new ArrayList<>();
        while(i < n){
            if(words[i].length() <= rem){
                curr.add(words[i]);
                rem -= words[i].length();
                rem -= 1;
                i++;
            } else {
                lines.add(new ArrayList<>(curr));
                rem = maxWidth;
                curr = new ArrayList<>();
            }
        }
        
        if(curr.size() > 0){
            lines.add(new ArrayList<>(curr));
        }
        
        List<String> result = new ArrayList<>();
        processLines(lines, maxWidth, result);
        
        return result;
    }
}