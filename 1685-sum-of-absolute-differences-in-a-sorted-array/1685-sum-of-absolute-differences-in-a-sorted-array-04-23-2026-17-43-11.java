class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0, n = nums.length;
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] += i*nums[i] - sum;
            sum += nums[i];
        }
        sum = 0;
        for(int i = n - 1; i >= 0; i--){
            arr[i] += sum - (n - 1 - i)*nums[i];
            sum += nums[i];
        }

        return arr;
    }
}