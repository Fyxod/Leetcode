class Solution {
    public int candy(int[] rating) {
        int n = rating.length;
        
        int cnt = 1;
        int i = 1;
        while(i < n){
            if(rating[i] == rating[i - 1]){
                i++;
                cnt++;
                // continue;
            }
            int peak = 1;
            while(i < n && rating[i] > rating[i - 1]){
                peak++;
                cnt += peak;
                i++;
            }
            int down = 1;
            while(i < n && rating[i] < rating[i - 1]){
                cnt += down;
                down++;
                i++;
            }
            if(down > peak) cnt += down - peak;
        }

        return cnt;
    }
}