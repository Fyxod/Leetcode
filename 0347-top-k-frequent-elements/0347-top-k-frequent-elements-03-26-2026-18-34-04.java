class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int a : nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Integer>[] arr = new ArrayList[n + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(arr[val] == null) arr[val] = new ArrayList<>();
            arr[val].add(key);
        }

        int ans[] = new int[k];
        for(int i = n; i >= 1 && k > 0; i--){
            if(arr[i] == null) continue;
            for(int a : arr[i]){
                ans[k - 1] = a;
                k--;
            }
        }

        return ans;
    }
}