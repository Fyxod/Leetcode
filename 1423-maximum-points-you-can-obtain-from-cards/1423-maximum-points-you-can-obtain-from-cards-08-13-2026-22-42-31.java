class Solution {
    public int maxScore(int[] points, int k) {
        int n = points.length;
        int front[] = new int[n + 1];
        int back[] = new int[n + 1];
        front[0] = 0;
        back[0] = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += points[i];
            front[i + 1] = sum;
        }
        sum = 0;
        for(int i = n - 1; i >= 0; i--){
            sum += points[i];
            back[n - i] = sum;
        }

        int max = 0;
        for(int i = 0; i <= k; i++){
            max = Math.max(max, front[i] + back[k - i]);
        }
        return max;
    }
}