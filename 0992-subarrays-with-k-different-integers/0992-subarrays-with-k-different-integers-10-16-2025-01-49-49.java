class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count1 = subarraysWithatMostKDistinct(nums, k);
        int count2 = subarraysWithatMostKDistinct(nums, k - 1);

        return count1 - count2;
    }

    public int subarraysWithatMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int l = 0, r = 0;

        while(r < nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            
            while(map.size() > k){
                int el = nums[l];
                map.put(el, map.get(el) - 1);
                if(map.get(el) == 0) map.remove(Integer.valueOf(el));
                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;
    }
}