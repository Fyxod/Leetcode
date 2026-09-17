class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int tot = m * n;

        int low = 0, high = tot - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int r = mid / n;
            int c = mid % n;

            int val = matrix[r][c];
            if(val == target) return true;
            if(val > target) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}