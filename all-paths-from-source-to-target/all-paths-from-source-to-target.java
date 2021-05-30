class Solution {
    List<List<Integer>> result;
    
    public void allPathUtil(int[][] graph, int start, List<Integer> currentPath, int n) {
        if (start == n-1){
            currentPath.add(start);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(currentPath);
            result.add(temp);
            currentPath.remove(new Integer(start));
            return;
        }
        for(int i=0;i<graph[start].length;i++){
            currentPath.add(start);
            allPathUtil(graph, graph[start][i], currentPath, n);
            currentPath.remove(new Integer(start));
            // currentPath.remove(currentPath.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        allPathUtil(graph, 0, new ArrayList<>(), graph.length);
        return result;
    }
}