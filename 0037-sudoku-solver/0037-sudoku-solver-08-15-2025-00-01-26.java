class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(safe(board, i, j, k)){
                            board[i][j] = k;
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean safe(char[][] board, int row, int col, char el){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == el) return false;
            if(board[i][col] == el) return false;
            if(board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == el) return false;
        }
        return true;
    }
}