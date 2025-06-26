class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
       int low = 0, high = n;

       while(low <= high){
        int mid = low + (high - low) / 2;

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i = 0; i < m; i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                maxIndex = i;
            }
        }

        int el = mat[maxIndex][mid];

        int left = (mid - 1 >= 0)? mat[maxIndex][mid - 1] : -1;
        int right = (mid + 1 < n)? mat[maxIndex][mid + 1] : -1;

        if(el > left && el > right) return new int[]{maxIndex, mid};
        if(el < left) high = mid - 1;
        if(el < right) low = mid + 1;
       }
       return new int[]{-1, -1};
    }
}