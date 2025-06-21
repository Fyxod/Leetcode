class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(check(nums, mid, threshold)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean check(int nums[], int divisor, int threshold){
        int sum = 0;

        for(int a : nums){
            sum += Math.ceil((double)a / divisor);
            if(sum > threshold) return false;
        }
        return true;
    }
}