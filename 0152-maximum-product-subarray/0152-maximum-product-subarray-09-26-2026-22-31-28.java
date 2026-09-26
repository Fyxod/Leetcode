class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0], min = nums[0];
        int n = nums.length;

        for(int i = 1; i < n; i++){
            int x = nums[i];
             if(x < 0){
                int temp = max;
                max = min;
                min = temp;
             }
            
            max = Math.max(x, max * x);
            min = Math.min(x, min * x);
            ans = Math.max(ans, max);
        }

        return ans;
    }
}