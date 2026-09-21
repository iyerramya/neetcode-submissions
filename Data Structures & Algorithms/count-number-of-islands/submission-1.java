class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        // int numIslands = 0;
        // int[][] visited = new int[grid.length][grid[0].length];
        // for(int i=0; i<grid.length; i++) {
        //     for(int j=0; j<grid[0].length; j++) {
        //         if(visited[i][j] == 0 && grid[i][j] == '1') {
        //             numIslands++;
        //             dfs(grid, visited, i, j);
        //         }
        //     }
        // }
        // return numIslands;

        int numIslands = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    numIslands++;
                    bfs(grid, i, j);
                }

            }
        }
        return numIslands;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '0';
        q.add(new int[]{i,j});
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for(int[] dir: dirs) {
                int nr = row+dir[0];
                int nc = col+dir[1];
                if(nr >= 0 && nc >=0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = '0';
                }
            }
        }
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
