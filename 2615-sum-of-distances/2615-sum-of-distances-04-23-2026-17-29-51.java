class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long ans[] = new long[n];
        Map<Integer, long[]> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int a = nums[i];
            if(!map.containsKey(a)){
                map.put(a, new long[]{1, i});
            }
            else{
                long arr[] = map.get(a);
                ans[i] += arr[0] * i - arr[1];
                arr[0]++;
                arr[1] += i;
            }
        }
        map = new HashMap<>();
        for(int i = n - 1; i >= 0; i--){
            int a = nums[i];
            if(!map.containsKey(a)){
                map.put(a, new long[]{1, i});
            }
            else{
                long arr[] = map.get(a);
                ans[i] += arr[1] - arr[0] * i ;
                arr[0]++;
                arr[1] += i;
            }
        }

        return ans;
    }
}