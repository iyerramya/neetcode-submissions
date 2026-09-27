class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();
        for(int i=0; i<n;i++) {
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean isValid = true;
        if(!dfs(-1,0,adjList,visiting)) {
            return false;
        }
        
        return visiting.size() == n;
    }

    private boolean dfs(int parent, int curr, Map<Integer, List<Integer>> adjList, Set<Integer> visiting) {
        if(visiting.contains(curr)) {
            return false;
        }
        visiting.add(curr);
        for(int dep : adjList.get(curr)) {
            if(dep == parent) {
                continue;
            }
            if(!dfs(curr, dep, adjList, visiting)) {
                return false;
            }
        }
        return true;
    }
}
