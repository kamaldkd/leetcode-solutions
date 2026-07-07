class Solution {
    public void dfs(int i, int j, char[][] board, int[][] vis, int[][] dir) {
        board[i][j] = 'S';
        vis[i][j] = 1;

        for(int k = 0; k < 4; k++) {
            int row = i + dir[k][0];
            int col = j + dir[k][1];

            if(row >= 0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] == 'O' && vis[row][col] == 0 ) {
                dfs(row, col, board, vis, dir);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];
        int[][] dir = {
            {-1, 0},
            {0, +1},
            {+1, 0},
            {0, -1}
        };


        // first col
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, board, vis, dir);
            }
        }

        // last col
        for(int i = 0; i < n; i++) {
            if(board[i][m-1] == 'O') {
                dfs(i, m-1, board, vis, dir);
            }
        }

        // first row
        for(int j = 1; j < m-1; j++) {
            if(board[0][j] == 'O') {
                dfs(0, j, board, vis, dir);
            }
        }

        // last row
        for(int j = 1; j < m-1; j++) {
            if(board[n-1][j] == 'O') {
                dfs(n-1, j, board, vis, dir);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}