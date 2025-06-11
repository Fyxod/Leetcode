class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        getSpiral(matrix, m, n, 0, -1, 0, 1, result);
        return result;
    }

    void getSpiral(int matrix[][], int m, int n, int r, int c, int dr, int dc, List<Integer> result){
        if(m == 0 || n == 0) return;

        for(int i = 0; i < n; i++){
            r += dr;
            c += dc;
            result.add(matrix[r][c]);
        }

        getSpiral(matrix, n, m - 1, r, c, dc, -dr, result);
    }
}