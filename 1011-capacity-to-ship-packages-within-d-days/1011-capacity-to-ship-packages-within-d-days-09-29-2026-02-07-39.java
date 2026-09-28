class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int num : weights) {
            high += num;
            low = Math.max(low, num);
        }

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            int cnt = 1;
            int curr = mid;
            for(int a : weights){
                if(a > curr){
                    cnt++;
                    curr = mid - a;
                }
                else curr -= a;
            }
            if(cnt <= days){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }
}