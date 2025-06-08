class Solution {
    public void nextPermutation(int[] nums) {
        int i = 2;
        int size = nums.length;
        int max = nums[size - 1];
        int curr = nums[size - 1];
        int maxIndex = size - 1;
        while(i <= size){
            int n = nums[size - i];
            if(n > max){
                max = n;
                maxIndex = size - i;
            }
            curr = curr + (int)Math.pow(n, Integer.toString(curr).length());
            if(max != n){
                int tempMax = max;
                int tempMaxIndex = maxIndex;
                for(int k = size - i; k < size; k++){
                    if(nums[k] > n && nums[k] < tempMax){
                        tempMax = nums[k];
                        tempMaxIndex = k;
                    }
                }
                nums[size - i] = tempMax;
                nums[tempMaxIndex] = n;
                Arrays.sort(nums, size - i + 1, size);
                return;
            }
            else i++;
        }
        Arrays.sort(nums);
        return;
    }
}