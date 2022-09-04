/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class Node {
        TreeNode root;
        int idx;
        
        Node(TreeNode r, int i){
            root = r;
            idx = i;
        }
    }
    
    public void sortMapByValues(Map<Integer, List<Integer>> map){
        for(int key: map.keySet()){
            List<Integer> curr = map.get(key);
            Collections.sort(curr);
            map.put(key, curr);
        }
    }
    
    public List<Integer> getSortedKeySet(Map<Integer, List<int[]>> map) {
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        return list;
    }
    
    Comparator<int[]> customComparator = new Comparator<int[]>(){
        public int compare(int[] a1, int []a2) {
            //row is on 2nd
            int val = Integer.compare(a1[1],a2[1]);
            if(val != 0){
                return val;
            }
            
            return Integer.compare(a1[0], a2[0]);
        }
    };
    
    public List<List<Integer>> getResult(Map<Integer, List<int[]>> map, List<Integer> sortedKey){
        List<List<Integer>> answer = new ArrayList<>();
        for(int key: sortedKey){
            List<int[]> curr = map.get(key);
            Collections.sort(curr, customComparator);
            
            List<Integer> modCurr = new ArrayList<>();
            for(int[] ele: curr){
                modCurr.add(ele[0]);
            }
            answer.add(modCurr);
        }
        
        return answer;
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> levelByMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(root, 0));
        int row = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            row++;
            for(int i=0; i<size; i++){
                Node temp = q.poll();
                List<int[]> curr = levelByMap.getOrDefault(temp.idx, new ArrayList<>());
                curr.add(new int[]{temp.root.val, row});
                levelByMap.put(temp.idx, curr);
                
                if(temp.root.left != null){
                    q.add(new Node(temp.root.left, temp.idx-1));
                }
                
                if(temp.root.right != null){
                    q.add(new Node(temp.root.right, temp.idx+1));
                }
            }
        }
        
        
        return getResult(levelByMap, getSortedKeySet(levelByMap));
        
    }
}