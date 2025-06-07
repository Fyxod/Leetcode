class Solution {
    public void nextPermutation(int[] nums) {
        int i = 2;
        int min = nums[nums.length - 1];
        int max = nums[nums.length - 1];
        int curr = nums[nums.length - 1];
        int maxIndex = nums.length - 1;
        while(i <= nums.length){
            int n = nums[nums.length - i];
            if(n > max){
                max = n;
                maxIndex = nums.length - i;
            }
            min = Math.min(min, n);
            curr = curr + (int)Math.pow(n, Integer.toString(curr).length());
            if(max != n){
                int tempMax = max;
                int tempMaxIndex = maxIndex;
                for(int k = nums.length - i; k < nums.length; k++){
                    if(nums[k] > n && nums[k] < tempMax){
                        tempMax = nums[k];
                        tempMaxIndex = k;
                    }
                }
                nums[nums.length - i] = tempMax;
                nums[tempMaxIndex] = n;
                System.out.println("value of i " + i);
                System.out.println(nums.length - i + 1);
                Arrays.sort(nums, nums.length - i + 1, nums.length);
                return;
            }
            else i++;
        }
        Arrays.sort(nums);
        return;
    }
}