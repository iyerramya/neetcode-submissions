class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if ((r == 0 || r == ROWS - 1 ||
                    c == 0 || c == COLS - 1) &&
                    board[r][c] == 'O') {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0,1}, {0,-1}};

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            if(board[r][c] == 'O'){
                for(int[] dir: dirs) {
                    board[r][c] = 'R';
                    int nr = r+dir[0];
                    int nc = c+dir[1];
                    if(nr >= 0 && nr < ROWS && nc >=0 && nc < COLS) {
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'R') {
                    board[i][j] = 'O';
                }
            }
        }    
    }
}
