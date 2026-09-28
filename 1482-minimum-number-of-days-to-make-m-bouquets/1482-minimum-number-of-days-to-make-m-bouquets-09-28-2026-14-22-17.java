class Solution {
    public int minDays(int[] flowers, int m, int k) {
        if((long)m * k > flowers.length) return -1;
        int low = 1;
        int high = 1;
        for(int day : flowers) high = Math.max(high, day);

        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(poss(flowers, m, k, mid)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }
    boolean poss(int flowers[], int m, int k, int wait){
        int cnt = 0;
        int curr = 0;
        for(int day : flowers){
            if(day <= wait){
                curr++;
                if(curr == k){
                    cnt++;
                    curr = 0;
                }
            }
            else curr = 0;
        }

        return cnt >= m;
    }
}