class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0, col = n - 1;

        while(col >= 0 || row < m){
            int el = matrix[row][col];
            if(el == target) return true;

            if(col > 0 && el > target) col--;
            else if(row < m - 1 && el < target) row++;
            else break;
        }
        return false;
    }
}