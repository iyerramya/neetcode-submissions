class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i=0; i<n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int numComponents = 0;
        int[] visited = new int[n];

        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                numComponents++;
                dfs(i, adj, visited);
            }
        }

        return numComponents;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adj, int[] visited) {
       visited[node] = 1;

        for(int i : adj.get(node)) {
           if(visited[i] == 0) {
            dfs(i, adj, visited);
           }
        }
    }
}