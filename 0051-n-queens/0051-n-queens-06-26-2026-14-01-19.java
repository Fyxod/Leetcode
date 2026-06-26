class Solution {
    List<List<String>> ans;
    int n;
    public List<List<String>> solveNQueens(int nn) {
        n = nn;
        boolean filled[] = new boolean[n];
        ans = new ArrayList<>();
        boolean board[][] = new boolean[n][n];
        
        dfs(board, filled, 0);
        return ans;
    }
    void dfs(boolean board[][], boolean filled[], int col){
        if(col == n){
            add(board);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!filled[i] && check(board, i, col)){
                board[i][col] = true;
                filled[i] = true;
                dfs(board, filled, col + 1);
                board[i][col] = false;
                filled[i] = false;
            }
        }
    }
    boolean check(boolean board[][], int r, int c){
        int tr = r, tc = c;
        while(r >= 0 && c >= 0){
            if(board[r][c]) return false;
            r--; c--;
        }
        r = tr; c = tc;
        while(r < n && c >= 0){
            if(board[r][c]) return false;
            r++; c--;
        }

        return true;
    }
    void add(boolean board[][]){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < n; j++){
                if(board[i][j]) str += "Q";
                else str += ".";
            }
            list.add(str);
        }
        ans.add(list);
    }
}