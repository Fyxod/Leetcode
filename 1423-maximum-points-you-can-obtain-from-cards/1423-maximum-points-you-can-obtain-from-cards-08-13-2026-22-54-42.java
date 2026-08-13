class Solution {
    public int maxScore(int[] points, int k) {
        int n = points.length;
        int sum = 0;
        for(int i = 0; i < k; i++) sum += points[i];
        int max = sum;
        int l = k - 1;
        for(int i = n - 1; i > n - 1 - k; i--){
            sum += points[i] - points[l--];
            max = Math.max(max, sum);
        }

        return max;
    }
}