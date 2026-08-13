class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }
    int f(int nums[], int k){
        if(k == 0) return 0;
        int n = nums.length;
        int freq[] = new int[n + 1];
        int ans = 0;
        int l = 0;
        int cnt = 0;

        for(int r = 0; r < n; r++){
            int el = nums[r];
            freq[el]++;
            if(freq[el] == 1) cnt++;

            while(cnt > k){
                int temp = nums[l];
                freq[temp]--;
                if(freq[temp] == 0) cnt--;
                l++;
            }
            ans += r - l + 1;
        }

        return ans;

    }
}