class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // int low = Arrays.stream(weights).max().getAsInt();
        // int high = Arrays.stream(weights).sum();

        int low = weights[0];
        int high = 0;

        for(int a : weights){
            low = Math.max(low, a);
            high += a;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(possible(weights, mid, days)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean possible(int[] nums, int weight, int days){
        int count = 1;
        int temp = 0;
        for(int a : nums){
            if(weight - temp >= a){
                temp += a;
            }
            else{
                temp = a;
                count++;
                if(count > days) return false;
            }
        }
        return true;
    }
}