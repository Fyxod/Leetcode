class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int returnArr[] = new int[2];
        int freq[] = new int[nums.length - 2];
        int count = 0;
        for (int num : nums) {
            if (freq[num] > 0) {
                returnArr[count++] = num;
                if (count > 2)
                    break;
                continue;
            }
            freq[num]++;
        }
        return returnArr;
    }
}