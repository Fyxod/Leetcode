class Solution {
    int m, n;
    int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][n - 1] == 'O') dfs(i, n - 1, board);
        }
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O') dfs(0, i, board);
            if(board[m - 1][i] == 'O') dfs(m - 1, i, board);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'S') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    void dfs(int r, int c, char board[][]){
        board[r][c] = 'S';

        for(int i = 0; i < 4; i++){
            int nr = r + DIR[i][0];
            int nc = c + DIR[i][1];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n || board[nr][nc] != 'O') continue;
            dfs(nr, nc, board);
        }
    }
}