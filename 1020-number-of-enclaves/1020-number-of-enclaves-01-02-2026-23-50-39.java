class Solution {
    int DIR[][] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 1) dfs(board, i, 0);
            if(board[i][n - 1] == 1) dfs(board, i, n - 1);
        }
        for(int j = 1; j < n - 1; j++){
            if(board[0][j] == 1) dfs(board, 0, j);
            if(board[m - 1][j] == 1) dfs(board, m - 1, j);
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1) count++;
            }
        }
        return count;
    }
    void dfs(int board[][], int r, int c){
        board[r][c] = 0;

        for(int dir[] : DIR){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr < board.length && nc < board[0].length && nr >= 0 && nc >= 0 && board[nr][nc] == 1)
                dfs(board, nr, nc);
        }
    }
}