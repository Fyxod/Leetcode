class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for(int pile : piles) high = Math.max(high, pile);

        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(possible(piles, mid, h)){
                high = mid - 1;
                ans = mid;
            }
            else low = mid + 1;
        }

        return ans;
    }

    boolean possible(int piles[], int speed, int h){
        int cnt = 0;
        for(int num : piles){
            cnt += (num + speed - 1) / speed;
            if(cnt > h) return false;
        }
        return true;
    }
}