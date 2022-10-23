class Solution {
    public void topologicalSort(Map<String, Set<String>> adj, Set<String> supplySet, Map<String, Integer> indegree, Set<String> recipeSet, List<String> result) {
	
        Queue<String> q = new LinkedList<>();
        for(String str: supplySet){
            if(indegree.getOrDefault(str, 0) == 0){
                q.add(str);
            }
        }

        while(!q.isEmpty()){
            String curr = q.poll();
            if(recipeSet.contains(curr)){
                result.add(curr);
            }

            for(String ele: adj.getOrDefault(curr, new HashSet<>())){
                indegree.put(ele, indegree.getOrDefault(ele,0) - 1);
                if(indegree.get(ele) == 0){
                    q.add(ele);
                }
            }
        }
        
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> result = new ArrayList<>();
        Map<String, Set<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Set<String> supplySet = new HashSet<>();
        Set<String> recipeSet = new HashSet<>();
        Collections.addAll(supplySet, supplies);
        Collections.addAll(recipeSet, recipes);

        int n = recipes.length;
        for(int i=0; i<n; i++) {
            String recipe = recipes[i];
            for(String ing: ingredients.get(i)){
                adj.putIfAbsent(ing, new HashSet<>());
                adj.get(ing).add(recipe);

                indegree.putIfAbsent(recipe, 0);
                indegree.put(recipe, indegree.get(recipe) + 1);
            }
        }

        topologicalSort(adj, supplySet, indegree, recipeSet, result);	
        return result;
    }

}