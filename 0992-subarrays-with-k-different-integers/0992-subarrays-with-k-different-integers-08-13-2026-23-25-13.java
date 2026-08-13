class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }
    int f(int nums[], int k){
        if(k == 0) return 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int l = 0;
        for(int r = 0; r < n; r++){
            int el = nums[r];
            map.put(el, map.getOrDefault(el, 0) + 1);
            
            while(map.size() > k){
                int num = nums[l];
                int temp = map.get(num);
                if(temp == 1) map.remove(num);
                else map.put(num, temp - 1);
                l++;
            }
            ans += r - l + 1;
        }

        return ans;

    }
}