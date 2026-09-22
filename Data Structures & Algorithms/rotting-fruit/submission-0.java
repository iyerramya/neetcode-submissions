class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int freshCount = 0;
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0;
        int res = 0;
        while(!q.isEmpty() && freshCount > 0) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int newR = curr[0] + dir[0];
                    int newC = curr[1] + dir[1];
                    if(newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length || grid[newR][newC] != 1) {
                       continue; 
                    }
                    grid[newR][newC] = 2;
                    q.offer(new int[]{newR, newC});
                    freshCount--;
                }
            }
            res++;
        }
        return freshCount == 0 ? res : -1;
    }
}
