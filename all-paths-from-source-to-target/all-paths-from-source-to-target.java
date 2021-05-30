class Solution {
    List<List<Integer>> result;
    
    public void allPathUtil(int[][] graph, int start, List<Integer> currentPath, int n) {
        if (start == n-1){
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for( int v: graph[start]) {
            currentPath.add(v);
            allPathUtil(graph, v, currentPath, n);
            currentPath.remove(new Integer(v));
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathUtil(graph, 0, path, graph.length);
        return result;
    }
}