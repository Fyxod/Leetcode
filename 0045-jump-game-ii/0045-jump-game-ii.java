class Solution {
    public int jump(int[] nums) {
        int index = 0;
        if (nums.length == 1)
            return 0;
            int count = 0;
        while (index < nums.length - 1) {
            int maxIndex = index + 1;

            for (int i = 1; i <= nums[index]; i++) {
                if (index + i >= nums.length - 1)
                    break;
                if (nums[maxIndex] <= nums[index + i] || index + i >= nums[maxIndex] + maxIndex) {
                    maxIndex = index + i;
                }
            }
            if(index != maxIndex) count++;
            index = maxIndex;
        }
        return count;
    }
}

