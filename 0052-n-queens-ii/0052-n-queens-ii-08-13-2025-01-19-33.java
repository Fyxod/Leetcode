class Solution {
    public int totalNQueens(int n) {
        List<StringBuilder> curr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            curr.add(new StringBuilder(String.valueOf('.').repeat(n)));
        }
        int ans = f(n, curr, 0);
        return ans;
    }   
    int f(int n, List<StringBuilder> curr, int col){
        if(col == n){
            return 1;
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(Place(curr, i, col)){
                curr.get(i).setCharAt(col, 'Q');
                count += f(n, curr, col + 1);
                curr.get(i).setCharAt(col, '.');
            }
        }
        return count;
    }
    boolean Place(List<StringBuilder> curr, int row, int col){
        int t1 = row, t2 = col;
        while(row > -1 && col > -1){
            if(curr.get(row).charAt(col) == 'Q') return false;
            row--; col--;
        }
        row = t1; col = t2;
        while(col > -1){
            if(curr.get(row).charAt(col--) == 'Q') return false;
        }

        col = t2;
        while(col > -1 && row < curr.size()){
            if(curr.get(row++).charAt(col--) == 'Q') return false;
        }
        return true;
    }
}