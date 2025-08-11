class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean used[][] = new boolean[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(word.charAt(0) == board[i][j] && helper(board, word, 0, i, j, used))
                    return true;
            }
        }
        return false;
    }
    boolean helper(char[][] board, String word, int index, int r, int c, boolean used[][]){
        if(index == word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if(used[r][c]) return false;
        if(word.charAt(index) != board[r][c]) return false;
        used[r][c] = true;

        boolean result = helper(board, word, index + 1, r + 1, c, used) ||
               helper(board, word, index + 1, r - 1, c, used) ||
               helper(board, word, index + 1, r, c + 1, used) ||
               helper(board, word, index + 1, r, c - 1, used);

        used[r][c] = false;
        return result;
    }
}