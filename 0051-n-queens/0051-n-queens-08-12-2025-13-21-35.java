class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> curr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            curr.add(new StringBuilder(String.valueOf('.').repeat(n)));
        }
        f(n, ans, curr, 0);
        return ans;
    }
    void f(int n, List<List<String>> ans, List<StringBuilder> curr, int col){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(StringBuilder sb : curr){
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        for(int i = 0; i < n; i++){
            if(Place(curr, i, col)){
                curr.get(i).setCharAt(col, 'Q');
                f(n, ans, curr, col + 1);
                curr.get(i).setCharAt(col, '.');
            }
        }
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