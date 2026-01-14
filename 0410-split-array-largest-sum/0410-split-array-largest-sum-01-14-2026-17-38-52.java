class Solution {
    public int splitArray(int[] nums, int k) {
        // int low = Arrays.stream(nums).max().getAsInt();
        // int high = Arrays.stream(nums).sum();
        int low = nums[0];
        int high = 0;
        for(int a : nums){
            high += a;
            low = Math.max(low, a);
        }

        while(low < high){
            int mid = low + (high - low) / 2;

            if(calcSub(nums, mid) > k){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    
    int calcSub(int nums[], int max){
        int sum = 0;
        int count = 1;

        for(int a : nums){
            if(sum + a <= max){
                sum += a;
            }
            else{
                count++;
                sum = a;
            }
        }
        return count;
    }
}
