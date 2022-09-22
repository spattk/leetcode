class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean insideBlock = false;
        String out = "";
        for(String line: source){
            
            
            for(int i=0; i<line.length(); i++){
                
                if(!insideBlock){
                    
                    if(i == line.length()-1){
                        out += line.charAt(i);
                    } 
                    
                    else {
                        
                        String t = line.substring(i, i+2);
                        if(t.equals("/*")){
                            insideBlock = true;
                            i++;
                        } 
                        
                        else if(t.equals("//")){
                            break;
                        } 
                        
                        else {
                            out += line.charAt(i);
                        }
                    }
                } 
                
                else {
                    
                    if(i != line.length() -1 ){
                        String t = line.substring(i, i+2);
                        if(t.equals("*/")){
                            insideBlock = false;
                            i++;
                        }
                    }
                   
                }
            }
            
            if(!out.equals("") && !insideBlock) {
                result.add(out);
                out = "";
            }
            
        }
        
        return result;
    }
}