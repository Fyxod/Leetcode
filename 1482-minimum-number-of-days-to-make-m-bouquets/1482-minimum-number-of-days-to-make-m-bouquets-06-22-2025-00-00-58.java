class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;

        int low = 1;
        int high = bloomDay[0];

        for(int a : bloomDay){
            high = Math.max(a, high);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(getB(bloomDay, k, mid) < m){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }

    int getB(int[] nums, int k, int days){
        int count = 0;
        int flag = 0;

        for(int a : nums){
            if(days >= a){
                flag++;
                if(flag == k){
                    count++;
                    flag = 0;
                }
            }
            else{
                flag = 0;
            }
        }
        return count;
    }
}