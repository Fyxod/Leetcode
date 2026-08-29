class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pos = 0, neg = 1;
        for(int i = 0; i < n; i++){
            int a = nums[i];
            if(a > 0){
                ans[pos] = a;
                pos += 2;
            }
            else if(a < 0){
                ans[neg] = a;
                neg += 2;
            }
        }

        return ans;
    }
}