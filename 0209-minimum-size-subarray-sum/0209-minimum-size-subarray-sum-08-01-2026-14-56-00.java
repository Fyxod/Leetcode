class Solution {
    int arr[];
    int n;
    int INF = Integer.MAX_VALUE / 2;
    public int minSubArrayLen(int target, int[] nums) {
        int ans = INF;    
        n = nums.length;
        arr = new int[n];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            arr[i] = sum;
            if(sum >= target) ans = Math.min(ans, i + 1);
            if(sum > target) ans = Math.min(ans, f(target, sum, nums, i));
        }

        return ans == INF ? 0 : ans;
    }
    int f(int target, int sum, int nums[], int i){
        int left = 0;
        int right = i;

        int ans = INF;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(sum - arr[mid] >= target){
                ans = i - mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return ans;
    }
}