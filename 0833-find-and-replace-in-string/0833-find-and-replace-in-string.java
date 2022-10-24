class Solution {

	class Node {
		int idx;
		int len;
		String src;
		String target;

		Node(int idx, int len, String src, String target){
			this.idx = idx;
			this.len = len;
			this.src = src;
			this.target = target;
		}
        
        public String toString(){
            return "[" + this.idx + " " +
			this.len + " " +
			this.src+ " "+
			this.target + " ]";
        }
	}
	public void buildString(Map<Integer, Node> map, StringBuilder sb, String s){
		int n = s.length();
		for(int i=0; i<n;){
			Node ele = map.get(i);
			if(ele != null && s.substring(ele.idx, ele.idx+ele.len).equals(ele.src)){
				sb.append(ele.target);
                i+= ele.len;
			}

			else {
				sb.append(s.charAt(i));
                i++;
			}
		}
	}

	public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
     		Map<Integer, Node> map = new HashMap<>();
		int n = indices.length;
		for(int i=0; i<n; i++){
			map.put(indices[i], new Node(indices[i], sources[i].length(), sources[i], targets[i]));
		}

		StringBuilder sb = new StringBuilder();
	
		buildString(map, sb, s);

		return sb.toString();
    	}
}


