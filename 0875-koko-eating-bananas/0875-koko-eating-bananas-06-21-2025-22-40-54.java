class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = piles[0];

        for(int a : piles){
            max = Math.max(max, a);
        }
        int high = max;
        
        while(low <= high){
            int mid = low + (high - low) / 2;

            int hours = getH(piles, mid);
            if(hours <= h){
                max = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return max;
    }

    int getH(int[] piles, int count){
        int hours = 0;
        for(int a : piles){
            hours += Math.ceil((double)a / count);
        }
        return hours;
    }
}