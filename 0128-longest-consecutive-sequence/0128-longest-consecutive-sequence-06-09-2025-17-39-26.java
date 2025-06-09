class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0];
        int min = Integer.MAX_VALUE;
        for(int a : nums){
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        if(min < 0) min*=-1;
        int arr[] = new int[max + min + 1];

        for(int a : nums){
            arr[a + min]++;
        }
        int ans = 1;
        int temp = 0;

        for(int a : arr){
            if(a > 0){
                temp++;
                ans = Math.max(ans, temp);
            }
            else temp = 0;
        }
        return ans;
    }
}