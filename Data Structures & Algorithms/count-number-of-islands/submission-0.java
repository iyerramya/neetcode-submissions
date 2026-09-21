class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if(grid[i][j] == '0' || visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        for(int[] dir : dirs) {
            dfs(grid, visited, i+dir[0], j+dir[1]);
        }  

    }
}
