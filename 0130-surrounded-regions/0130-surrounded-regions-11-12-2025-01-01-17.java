class Solution {
    int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean vis[][] = new boolean[m][n];

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(i, 0, board, m, n);
            if(board[i][n - 1] == 'O') dfs(i, n - 1, board, m, n);
        }
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O') dfs(0, i, board, m, n);
            if(board[m - 1][i] == 'O') dfs(m - 1, i, board, m, n);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '1') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    void dfs(int r, int c, char[][] board, int m, int n){
        if(r < 0 || r > m - 1 || c < 0 || c > n - 1 || board[r][c] != 'O') return;
        board[r][c] = '1';

        for(int i = 0; i < dir.length; i++){
            dfs(r + dir[i][0], c + dir[i][1], board, m, n);
        }
    }
}